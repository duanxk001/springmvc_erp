package com.zx.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * springMVC测试类
 * 
 */
@Controller
public class SpringMVCtest {
	
	/*
	 * 返回ajax信息
	 */
	public void sendMessage(){
		
	}
	
	
	/*
	 * 页面跳转
	 */
	@RequestMapping("login.do")
	public String redirectPage(){
		
		return "success";
	}
}
