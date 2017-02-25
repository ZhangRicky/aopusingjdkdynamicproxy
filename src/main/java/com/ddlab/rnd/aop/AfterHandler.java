package com.ddlab.rnd.aop;

import java.lang.reflect.Method;

/**
 * The Class AfterHandler provides a template for After concern.
 *
 * @author Debadatta Mishra
 */
public abstract class AfterHandler extends AbstractHandler {

	/**
	 * Handles after the execution of method.
	 *
	 * @param proxy the proxy
	 * @param method the method
	 * @param args the args
	 */
	public abstract void handleAfter(Object proxy, Method method, Object[] args);
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 * 作为动态代理对象的所有方法实现体
	 * 执行动态代理对象的所有方法之后，都会被替换执行如下invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = method.invoke(getTargetObject(), args);
		handleAfter(proxy, method, args);
		return result;
	}
}
