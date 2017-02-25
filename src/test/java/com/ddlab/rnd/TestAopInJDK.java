package com.ddlab.rnd;

import java.util.ArrayList;
import java.util.List;

import com.ddlab.rnd.aop.AbstractHandler;
import com.ddlab.rnd.aop.AfterHandler;
import com.ddlab.rnd.aop.BeforeHandler;
import com.ddlab.rnd.aop.ProxyFactory;
import com.ddlab.rnd.aop.impl.AfterHandlerImpl;
import com.ddlab.rnd.aop.impl.BeforeHandlerImpl;
import com.ddlab.rnd.beans.Calculator;
import com.ddlab.rnd.beans.CalculatorImpl;

/**
 * The Test class to verify our own aop using JDK proxy.
 *
 * @author Debadatta Mishra
 */
public class TestAopInJDK {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		//创建一个原始的CalculatorImpl对象
		CalculatorImpl calcImpl = new CalculatorImpl();
		
		BeforeHandler before = new BeforeHandlerImpl();//执行之前的AOP
		AfterHandler after = new AfterHandlerImpl();	//执行之后的AOP
		
		List<AbstractHandler> handlers = new ArrayList<AbstractHandler>();
		handlers.add(before);
		handlers.add(after);
		//以指定的对象来创建动态代理
		Calculator proxy = (Calculator) ProxyFactory.getProxy(calcImpl,handlers);
		//方法调用
		int result = proxy.calculate(20, 10);
		
		System.out.println("FInal Result :::" + result);
	}

}
