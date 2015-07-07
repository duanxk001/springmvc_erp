package com.zx.action;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.model.User;

/*
 * springMVC测试类
 * 
 */
@Controller
public class SpringMVCtest {
	
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
		JSONObject jobj = JSONObject.fromObject(user);
		return jobj.toString();
	}
	
	
	/*
	 * 页面跳转
	 */
	@RequestMapping("login.do")
	public String redirectPage(HttpServletRequest request){
		request.setAttribute("name","dxk");
		return "success";
	}
}
