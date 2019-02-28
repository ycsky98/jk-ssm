package test;

import java.util.List;

import cn.tedu.jk.entity.Factory;

public class ThreadDemo<T> implements Runnable{

	private List<T> list;
	
	public ThreadDemo(List<T> list){
		this.list = list;
	}
	
	public void run(){
		//测试输出取到的值
		//System.out.println(get());
		get();
	}
	
	public void get(){
		for (int i = 0; i < 10; i++) {
			T factory = this.list.remove(0);
			System.out.println(factory);
		}
	}
}
