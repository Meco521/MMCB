/**
 * @author Aq1u
 * @date 2/22/2024
 */
package dev.mmcb.api.event.handler;

import dev.mmcb.api.event.CancelableEvent;
import dev.mmcb.api.event.component.EventTarget;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
    private static final ConcurrentHashMap<Class<? extends CancelableEvent>, List<Listener>> registry = new ConcurrentHashMap<>();

    public static void register(Object object) {
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 1 && method.isAnnotationPresent(EventTarget.class)) {
                Class<?> event = method.getParameterTypes()[0];
                if (!registry.containsKey(event)) {
                    registry.put((Class<? extends CancelableEvent>) event, new CopyOnWriteArrayList<>());
                }
                registry.get(event).add(new Listener(method, object, method.getDeclaredAnnotation(EventTarget.class).priority()));
            }
        }
    }

    public static void unregister(Object object) {
        for (List<Listener> list : EventManager.registry.values()) {
            for (Listener data : list) {
                if (data.getParent() != object) continue;
                list.remove(data);
            }
        }
    }

    public static void call(CancelableEvent event) {
        List<Listener> list = EventManager.registry.get(event.getClass());
        if (list != null && !list.isEmpty()) {
            list.sort(Comparator.comparingInt(Listener::getPriority));
            for (Listener data : list) {
                try {
                    data.getHandler().invokeExact(data.getParent(), event);
                } catch (Throwable e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
