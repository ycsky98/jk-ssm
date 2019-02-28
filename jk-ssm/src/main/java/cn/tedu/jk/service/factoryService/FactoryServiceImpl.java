package cn.tedu.jk.service.factoryService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.jk.dao.FactoryDao;
import cn.tedu.jk.entity.Factory;

@Service("factoryService")
public class FactoryServiceImpl implements FactoryService{

	@Autowired
	private FactoryDao factoryDao;
	
	public List<Factory> findFactory() {
		List<Factory> list = factoryDao.findFactory();
		return list;
	}
	public Factory findById(Object id) {
		Factory foc = factoryDao.findById(id);
		return foc;
	}
	public void up(Factory foc) {
		factoryDao.up(foc);
	}
	public void insert(Factory foc){
		factoryDao.insert(foc);
	}
	public void delete(Object obj){
		factoryDao.delete(obj);
	}
}
