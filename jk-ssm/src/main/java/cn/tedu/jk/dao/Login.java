package cn.tedu.jk.dao;

import cn.tedu.jk.entity.User;

public interface Login {
	public User findByUser(Object username);
}
