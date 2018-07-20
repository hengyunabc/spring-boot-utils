package io.github.hengyunabc.autoconfigure.condition;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

/**
 *
 * @author duanling 2018-03-05
 *
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnClass(name = "org.springframework.boot.context.properties.bind.Binder")
public @interface ConditionalOnSpringBoot2 {

}