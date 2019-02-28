package cn.tedu.jk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.jk.entity.User;
import cn.tedu.jk.result.JsonResult;
import cn.tedu.jk.service.LoginService.LoginServiceImpl;
import cn.tedu.jk.util.Base64Util;

@Controller
public class HomeController {

	@Resource
	private LoginServiceImpl imp;
	
	//进入登录
	@RequestMapping("/.action")
	public String toIndex(HttpServletRequest request){
		return "index.jsp";
	}
	
	@RequestMapping(value="/toLogin.action",method={RequestMethod.POST})
	@ResponseBody
	public JsonResult toIndexLogin(HttpServletRequest request, HttpSession session){
		Base64Util util = new Base64Util();
		System.out.println(request.getParameter("userName"));
		User user = imp.findByUser(util.getFromBase64(request.getParameter("userName")));
		if (user!=null) {
			if (user.getPassworld().equals(util.getFromBase64(request.getParameter("password")))) {
				request.getSession().setAttribute("check", true);
				return new JsonResult();
			}
		}
		return new JsonResult(new RuntimeException("账号或密码错误"));
	}
	
	//进入首页
	@RequestMapping("/fmain.action")
	public String fmain(){
		return "home/fmain.jsp";
	}
	//顶部
	@RequestMapping("/title.action")
	public String title(){
		return "home/title.jsp";
	}
	//左侧菜单
	@RequestMapping("/left.action")
	public String left(){
		return "home/left.jsp";
	}
	//右侧功能区
	@RequestMapping("/main.action")
	public String olmsgList(){
		return "home/olmsgList.jsp";
	}
	//基础信息 -左边
	@RequestMapping("/baseinfoLeft.action")
	public String baseinfoLeft(){
		return "baseinfo/left.jsp";
	}
		//基础信息 - 右边
	@RequestMapping("/baseinfoMain.action")
	public String baseinfo(){
		return "baseinfo/main.jsp";
	}
	
}
