package org.dproxy.type;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MockerInnvocationHandler implements InvocationHandler {
	private Class<?> interf;

	public MockerInnvocationHandler(Class<?> i) {
		this.interf = i;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String name = method.getName();
		if("toString".equals(name)) {
			return this.interf.toString();
		}
		if("equals".equals(name)) {
			if(args.length == 1) {
				return proxy == args[0];
			}else {
				return false;
			}
		}
		if("hashCode".equals(name)) {
			MockerInnvocationHandler.super.hashCode();
			return this.interf.hashCode();
		}
		// ... any other base method from Object
		if(args != null && args.length > 0) {
			
		}
		
		
		return null;
	}

}
