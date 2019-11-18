package org.dproxy;

import java.lang.reflect.Proxy;
import java.net.URI;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.dproxy.annotation.Mocker;
import org.dproxy.type.MockHandler;
import org.dproxy.type.MockerInnvocationHandler;

public class MockerUtils {

	public static Set<Object> scan(Class<?>... interfaces){
		if(interfaces == null || interfaces.length == 0) {
			return Collections.emptySet();
		}
		Set<Object> result = new HashSet<Object>();
		for(Class<?> i : interfaces) {
			result.add(createObject(i));
		}
		return result;
	}
	
	private static Object createObject(Class<?> i) {
		if(!i.isInterface()) {
			throw new RuntimeException("interface supported only");
		}
		if(!i.isAnnotationPresent(Mocker.class)) {
			throw new RuntimeException("this interface didn't have Mocker annotation");
		}
		Object obj = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[] {i}, new MockerInnvocationHandler(i));
		System.out.println(i.isInstance(obj));
		System.out.println(i.isAssignableFrom(obj.getClass()));
		
		return obj;
	}

	public static void main(String[] args) {
		System.out.println(MockerUtils.class.getResource("junit/textui/TestRunner.class"));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("org/reflections"));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("org/dproxy"));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("org/redis/demo"));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("java/sql"));
		System.out.println(ClassLoader.getSystemResource("java/sql"));
		MockHandler mk = (MockHandler) MockerUtils.scan(MockHandler.class).toArray()[0];
		System.out.println(mk.echo());
		String strClassPath = System.getProperty("java.class.path");

		System.out.println("Classpath is " + strClassPath);
		
		try {
			ProtectionDomain protectionDomain = MockerUtils.class.getProtectionDomain();
			CodeSource codeSource = protectionDomain.getCodeSource();
			URI location = (codeSource != null) ? codeSource.getLocation().toURI() : null;
			String path = (location != null) ? location.getSchemeSpecificPart() : null;
			System.out.println(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
