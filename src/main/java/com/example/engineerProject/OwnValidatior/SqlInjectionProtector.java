package com.example.engineerProject.OwnValidatior;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
public @interface SqlInjectionProtector {
    String message() default "Text Contains SQL Injection attack";
    Class<?>[] groups() default {};

    Lang[] lang();
}
