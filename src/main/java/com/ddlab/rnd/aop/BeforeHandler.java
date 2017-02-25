package com.ddlab.rnd.aop;

import java.lang.reflect.Method;

/**
 * The Class BeforeHandler provides a template for the before execution
 *
 * @author Debadatta Mishra
 */
public abstract class BeforeHandler extends AbstractHandler {

	/**
	 * Handles before execution of actual method.
	 *
	 * @param proxy the proxy
	 * @param method the method
	 * @param args the args
	 */
	public abstract void handleBefore(Object proxy, Method method, Object[] args);
	
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 * 执行动态代理对象的所有方法之后，都会被替换执行如下invoke方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		handleBefore(proxy, method, args);
		return method.invoke(getTargetObject(), args);
	}
}
