package cn.tedu.jk.service.factoryService;

import java.util.List;

import cn.tedu.jk.entity.Factory;
import cn.tedu.jk.entity.User;

public interface FactoryService {
	// 所有厂商信息
	public List<Factory> findFactory();

	// 返回查找ID对应的厂商
	public Factory findById(Object obj);

	// 修改信息
	public void up(Factory foc);
	
	//插入信息
	public void insert(Factory foc);
	
	//删除信息
	public void delete(Object obj);
}