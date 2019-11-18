package org.dproxy;

import java.util.Set;

import org.reflections.Reflections;

public class MainTest {

	public static void main(String[] args) {
		Reflections reflections = new Reflections("org.redis.demo");
		System.out.println(reflections.getAllTypes());
		Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
		System.out.println(allClasses);
	}

}
