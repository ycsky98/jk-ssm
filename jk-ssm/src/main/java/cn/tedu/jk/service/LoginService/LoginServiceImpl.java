package cn.tedu.jk.service.LoginService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.jk.dao.Login;
import cn.tedu.jk.entity.User;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private Login login;
	
	public User findByUser(String obj) {
		User user = login.findByUser(obj);
		return user;
	}
}
