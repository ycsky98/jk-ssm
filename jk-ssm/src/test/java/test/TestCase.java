package test;

import java.util.Collections;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.jk.dao.FactoryDao;
import cn.tedu.jk.dao.Login;
import cn.tedu.jk.entity.Factory;
import cn.tedu.jk.entity.User;

public class TestCase {
	
	private String config = "conf/spring-mybatis.xml";
	private ApplicationContext ac;
	private FactoryDao dao;
	private Login login;
	
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext(config);
		dao = ac.getBean("factoryDao", FactoryDao.class);
		login = ac.getBean("login", Login.class);
	}
	
	@Test
	public void test1(){
		int i = 0;
		Workbook workbook = new HSSFWorkbook();
		List<Factory> list = Collections.synchronizedList(dao.findFactory());
		long a = System.currentTimeMillis();
		ThreadGetData<Factory> data = new ThreadGetData<Factory>();
		data.createThread(list, 3);
		System.out.println(System.currentTimeMillis()-a);
	}
	@Test
	public void test2(){
		Factory fac = dao.findById(10);
		fac.setFactoryName("晶晨");
		dao.up(fac);
		System.out.println("修改成功");
	}
	
	@Test
	public void test4(){
		User user = login.findByUser("admin");
		System.out.println(user.getAdmin());
		System.out.println(user.getPassworld());
	}
	
	@Test
	public void test5(){
		/*String str = "abcdtt0yyy";
		int a = str.lastIndexOf(0);
		System.out.println(a);*/
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < i / 2; j++) {
					sum += j;
				}
				System.out.println(sum);
				sum = 0;
			}
		}
	}
	
	@Test
	public void test8(){
		Object obj = new Object();
		Object object = new Integer(12);
		System.out.println(object);
		System.out.println(obj);
	}
	
}