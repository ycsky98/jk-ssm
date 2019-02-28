package test;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import cn.tedu.jk.entity.Factory;

/**
 * 多线程分导数据
 * 定义线程开启类
 * */
public class ThreadGetData<T>{
	
	public ThreadGetData(){
	}
	
	public void createThread(List<T> data,int threadCount){
		int length = data.size();
		int t = length%threadCount==0?length/threadCount:length/threadCount+1;//计算一个线程要处理多少数据

		//开启线程数处理数据
		for (int i = 0; i < threadCount; i++) {
			GetDate<T> l = new GetDate<T>(data, t);
			Thread thread = new Thread(l);
			thread.start();
		}
	}
	/**
	 * 该方法未开发完
	 * */
	public void createThreadToIO(List<T> data,int threadCount,Workbook workbook){
		workbook.createSheet();
		int length = data.size();
		int t = length%threadCount==0?length/threadCount:length/threadCount+1;//计算一个线程要处理多少数据

		//开启线程数处理数据
		for (int i = 0; i < threadCount; i++) {
			GetDate<T> l = new GetDate<T>(data, t);
			Thread thread = new Thread(l);
			thread.start();
		}
	}

	/**
	 * 线程类处理相对的数据
	 * */
	@SuppressWarnings("hiding")
	class GetDate<T> implements Runnable{
		private List<T> list;
		
		private int count;
		/**
		 * 赋值数据
		 * */
		public GetDate(List<T> data,int count){
			this.list = data;
			this.count = count;
		}
		
		public void run(){
			for (int i = 0; i < count; i++) {
				//防止最后抢资源导致下标越界
				if (this.list.size()==0) {
					return;
				}
				T t = this.list.remove(0);
				if (t.getClass()==new Factory().getClass()) {
					Factory f = (Factory)t;
					System.out.println(f.getFullName());
				}
			}
		}
	}
}

