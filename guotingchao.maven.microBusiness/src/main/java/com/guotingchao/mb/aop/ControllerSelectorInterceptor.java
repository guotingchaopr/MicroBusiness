/**   
* @Title: ControllerSelectorInterceptor.java
* @Package com.guotingchao.mb.aop
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-5 上午11:26:26
* @version V1.0   
*/
package com.guotingchao.mb.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ControllerSelectorInterceptor
 * @Description: TODO(将do开头的所有方法拦截)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-5 上午11:26:26
 * 
 */

@Aspect
@Component
public class ControllerSelectorInterceptor {
	@Before("execution(* com.guotingchao.mb.controller.*Controller.do*(..,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse))")
    public void doBefore(JoinPoint jp) {
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[args.length-2];
        request.setAttribute("aop", "ok");	
        System.out.println("before");
    }
 
     @After("execution(* com.guotingchao.mb.controller.*Controller.do*(..,javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse))")
     public void doAfter(JoinPoint jp) {  
        Object[] args = jp.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[args.length-2];
        String aop = (String) request.getAttribute("aop");
        System.out.println("after "+aop);
     }
}
