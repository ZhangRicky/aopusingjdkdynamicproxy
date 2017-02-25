package com.ddlab.rnd.aop;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 代理工厂，专门加工需要代理的对象，并将该对象返回给用户
 * 专门为指定的target生成动态代理的实例
 * A factory for creating Proxy objects.
 * @author Debadatta Mishra
 */
public class ProxyFactory {

	/**
	 * Gets the proxy.
	 *批量生成动态代理对象
	 * @param targetObject the target object
	 * @param handlers the handlers
	 * @return the proxy
	 */
	public static Object getProxy(Object targetObject,List<AbstractHandler> handlers) {
		Object proxyObject = null;
		if (handlers.size() > 0) {
			proxyObject = targetObject;
			for (int i = 0; i < handlers.size(); i++) {
				//为设置target对象
				handlers.get(i).setTargetObject(proxyObject);
				//创建一个动态代理
				proxyObject = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass()
						.getInterfaces(), handlers.get(i));
			}
			return proxyObject;
		} else {
			return targetObject;
		}
	}
}
