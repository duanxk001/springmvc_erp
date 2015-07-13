package com.zx.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zx.model.User;
import com.zx.service.LoginService;

/*
 * springMVC测试类
 * 
 */
@Controller
public class SpringMVCtest {
	
	
	protected HttpServletRequest request;  
	protected HttpServletResponse response;  
	protected HttpSession session;  
	
	@Autowired
	private LoginService loginService;
	          
	@ModelAttribute  
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){  
	    this.request = request;  
	    this.response = response;  
	    this.session = request.getSession();  
	}
	
	/*
	 * 返回ajax信息
	 */
	@RequestMapping("check.do")
	@ResponseBody    //注解表示返回值不进行跳转，而直接写入response中
	public String sendMessage(){
		/*Map<String, String> map = new HashMap<String,String>();
		map.put("name","duanxk");*/
		User user = new User();
		user.setName("dxk");
		user.setPasswd("123");
		String jobj = JSON.toJSONString(user);
		return jobj;
	}
	
	
	/*
	 * 页面跳转
	 */
	@RequestMapping("login.do")
	public String redirectPage(HttpServletRequest request){
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123123123123");
	    Subject currentUser = SecurityUtils.getSubject();
	    try {
	      currentUser.login(token);
	    } catch (AuthenticationException ae) {
	      ae.printStackTrace();
	    }
		request.setAttribute("name","dxk");
		return "../index";
	}
	
	@RequestMapping("findAllFunctionList.do")
	public void loadMenu(){
		OutputJson(loginService.getMenu());
	}
	
	@RequestMapping("findParameterList.do")
	public void loadSystemParameter(){
		OutputJson(loginService.getSystemParameter());
	}
	
	
	public void OutputJson(Object object) {
		PrintWriter out = null;
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		//String json = null;
		String json = null;
		try {
			out = response.getWriter();
			json = JSON.toJSONString(object);
			//json = JSON.toJSONStringWithDateFormat(object,"yyyy-MM-dd HH:mm:ss");
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(json);
		out.close();
	}
}
