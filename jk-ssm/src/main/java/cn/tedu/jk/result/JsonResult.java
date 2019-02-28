package cn.tedu.jk.result;

/**
 * 借助此对象封装Controller方法中有@ResponseBody注解的方法返回的数据
 * 目的:统一返回值,便于在页面上进行统一封装处理
 * */
public class JsonResult {
	private static final int SUCCESS = 1;
	private static final int ERROR = 0;
	/**状态*/
	private int state;
	/**对应状态的消息*/
	private String message;
	/**具体业务数据*/
	private Object data;
	
	/**此方法应用于data为null的场景*/
	public JsonResult(){
		this.state=SUCCESS;
		this.message="OK";
	}
	/**有具体业务数据返回时,使用此构造方法*/
	public JsonResult(Object obj){
		this();
		this.data = obj;
	}
	/**出现异常后调用此方法*/
	public JsonResult(Throwable t){
		this.state=ERROR;
		this.message=t.getMessage();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static int getSuccess() {
		return SUCCESS;
	}
	public static int getError() {
		return ERROR;
	}
}
