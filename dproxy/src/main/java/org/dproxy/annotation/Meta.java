package org.dproxy.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.dproxy.type.MockHandler;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Meta {
	
	String pattern() default "";

	Class<? extends MockHandler> handler();
}
