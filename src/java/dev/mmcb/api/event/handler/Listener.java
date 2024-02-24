/**
 * @author Aq1u
 * @date 2/22/2024
 */
package dev.mmcb.api.event.handler;

import dev.mmcb.api.event.CancelableEvent;
import dev.mmcb.api.event.component.Priority;
import lombok.Getter;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

@Getter
public class Listener {
    private MethodHandle handler;
    private final Object parent;
    private final int priority;

    public Listener(Method method, Object parent, Priority priority) {
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        MethodHandle m;
        try {
            m = MethodHandles.lookup().unreflect(method);
            if (m != null) {
                this.handler = m.asType(m.type().changeParameterType(0, Object.class).changeParameterType(1, CancelableEvent.class));
            } else {
                throw new IllegalAccessException("MethodHandle cannot be null");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.parent = parent;
        this.priority = priority.getValue();
    }

}
