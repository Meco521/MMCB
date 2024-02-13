/**
 *
 * @author Meco
 * @date 2/13/2024
 */
package dev.mmcb.api.event.manager;

import dev.mmcb.api.event.CancelableEvent;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
    public static EventManager instance = new EventManager();
    private final ConcurrentHashMap<Class<? extends CancelableEvent>, List<Listener>> registry = new ConcurrentHashMap<>();
    private final Comparator<Listener> comparator = Comparator.comparingInt(Listener::getPriority);

    public void register(Object... objs) {
        for (Object obj : objs) {
            Method[] arrmethod = obj.getClass().getDeclaredMethods();
            for (Method m : arrmethod) {
                if (m.getParameterCount() == 1 && m.isAnnotationPresent(EventTarget.class)) {
                    Class<?> eventClass = m.getParameterTypes()[0];
                    if (!registry.containsKey(eventClass)) {
                        registry.put((Class<? extends CancelableEvent>) eventClass, new CopyOnWriteArrayList<>());
                    }
                    registry.get(eventClass).add(new Listener(m, obj, m.getDeclaredAnnotation(EventTarget.class).priority()));
                    registry.get(eventClass).sort(comparator);
                }
            }
        }
    }

    public void unregister(Object ... objs) {
        int n = objs.length;
        int n2 = 0;
        while (n2 < n) {
            Object obj = objs[n2];
            for (List<Listener> list : this.registry.values()) {
                for (Listener data : list) {
                    if (data.getParent() != obj) continue;
                    list.remove(data);
                }
            }
            ++n2;
        }
    }

    public <E extends CancelableEvent> E call(E event) {
        List<Listener> list = this.registry.get(event.getClass());
        if (list != null && !list.isEmpty()) {
            for (Listener data : list) {
                try {
                    data.getHandler().invokeExact(data.getParent(), event);
                }
                catch (Throwable e1) {
                    e1.printStackTrace();
                }
            }
        }
        return event;
    }
}
