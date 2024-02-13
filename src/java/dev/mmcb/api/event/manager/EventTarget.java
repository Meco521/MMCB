/**
 *
 * @author Meco
 * @date 2/13/2024
 */
package dev.mmcb.api.event.manager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTarget {
    byte priority() default 2;
}
