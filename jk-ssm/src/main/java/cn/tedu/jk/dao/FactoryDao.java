package cn.tedu.jk.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.jk.entity.Factory;
import cn.tedu.jk.entity.User;

public interface FactoryDao {
	//所有厂商信息
	public List<Factory> findFactory();
	//返回查找ID对应的厂商
	public Factory findById(Object obj);
	//修改信息
	public void up(Factory foc);
	//创建数据
	public void insert(Factory foc);
	//删除数据
	public void delete(Object obj);
}
