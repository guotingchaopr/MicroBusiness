/**   
* @Title: TestController.java
* @Package controller
* @Description: TODO(用一句话描述该文件做什么)
* @author guotingchaopr guotingchaopr@gmail.com
* @date 2014-4-4 下午11:41:50
* @version V1.0   
*/
package com.guotingchao.mb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guotingchao.mb.model.Users;
import com.guotingchao.mb.services.UserService;

/**
 * @ClassName: TestController
 * @Description: TODO(测试控制器)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-4 下午11:41:50
 * 
 */
@Controller
public class WxController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/microBusiness_wx")
	public String doSometing(HttpServletRequest request,HttpServletResponse response){
		return "test";
	}
	
	@RequestMapping("/getUser")
	public ModelAndView doGetUser(HttpServletRequest request,HttpServletResponse response){
		Long id = Long.parseLong(request.getParameter("uid"));
		Users user = userService.getUserById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("userinfo", user);
		mav.setViewName("user");
		return mav;
	}
}
