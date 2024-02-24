/**
 * @author Aq1u
 * @date 2/22/2024
 */
package dev.mmcb.api.event.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTarget {
    // Events with lower values will be prioritized.
    Priority priority() default Priority.Normal;
}
