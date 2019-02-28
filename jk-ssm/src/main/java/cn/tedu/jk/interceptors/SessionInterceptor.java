package cn.tedu.jk.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.jk.entity.User;

public class SessionInterceptor implements HandlerInterceptor{
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("check")==null) {
			response.sendRedirect(request.getContextPath()+"/.action");
			return false;
		}
		if((boolean)session.getAttribute("check")) {
			return true;
		}
		return false;
	}
}
