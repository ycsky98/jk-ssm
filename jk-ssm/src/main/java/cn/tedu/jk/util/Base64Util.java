package cn.tedu.jk.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * 2018-3-5
 * Base64加密
 * @author yangcong
 *
 */
public class Base64Util {
	
	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public String getBase64(String str){
		BASE64Encoder base64Encoder = new BASE64Encoder();
		//用于装str转换成的字节数据
		byte[] bs = null;
		try {
			bs = str.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回加密字符串
		return base64Encoder.encode(bs);
	}
	
	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public String getFromBase64(String str){
		//以下进行解密操作
		BASE64Decoder decoder = new BASE64Decoder();
		String s = null;
		try {
			s = new String(decoder.decodeBuffer(str),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
