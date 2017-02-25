package com.ddlab.rnd.aop;

import java.lang.reflect.InvocationHandler;

/**
 * The Class AbstractHandler provides a simple wrapper for our own aop.
 * 实现了InvocationHandler接口。
 *
 * @author Debadatta Mishra
 */
public abstract class AbstractHandler implements InvocationHandler {

	/** The target object. */
	//被代理对象
	private Object targetObject;
	
	/**
	 * Sets the target object.
	 *
	 * @param targetObject the new target object
	 */
	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	/**
	 * Gets the target object.
	 *
	 * @return the target object
	 */
	public Object getTargetObject() {
		return targetObject;
	}
}
