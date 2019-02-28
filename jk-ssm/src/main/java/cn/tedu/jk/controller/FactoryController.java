package cn.tedu.jk.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.jk.entity.Factory;
import cn.tedu.jk.entity.User;
import cn.tedu.jk.service.factoryService.FactoryService;
import cn.tedu.jk.util.DownloadUtil;

@Controller
public class FactoryController {

	@Resource
	private FactoryService factoryService;
	
	//厂家信息
	@RequestMapping(value="/basicinfo/factory/list.action",method={RequestMethod.POST,RequestMethod.GET})
	public String factoryList(Model model){
		//Model-----前端与后端数据交互
		List<Factory> list = factoryService.findFactory();
		model.addAttribute("datalist", list);
		return "basicinfo/factory/jFactoryList.jsp";
	}
	
	//查看厂家信息
	@RequestMapping("/basicinfo/factory/toview.action")
	public String factoryView(Model model,HttpServletRequest request){
		String id = request.getParameter("id");
		String ud = request.getParameter("ud");
		Factory finds = factoryService.findById(id);
		model.addAttribute("dataview",finds);
		request.setAttribute("ud",ud);
		return "basicinfo/factory/jFactoryView.jsp";
	}
	
	//修改厂家信息
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String factoryFindID(HttpServletRequest request){
		//获取厂家数据库的数据值
		String id = request.getParameter("id");
		Factory fa = factoryService.findById(id);
		request.setAttribute("UpdateFactory",fa);
		return "basicinfo/factory/jFactoryUpdate.jsp";
	}
	//点击确定后修改页面,然后跳转到显示层
	@RequestMapping("/basicinfo/factory/update.action")
	public String factoryUpdate(HttpServletRequest request){
		String id = request.getParameter("id");
		String fullname = request.getParameter("fullName");
		String factoryName = request.getParameter("factoryName");
		String contractor = request.getParameter("contractor");
		Factory factory = factoryService.findById(Integer.parseInt(id));
		factory.setFullName(fullname);
		factory.setFactoryName(factoryName);
		factory.setContractor(contractor);
		System.out.println(factory);
		factoryService.up(factory);
		return "redirect:list.action";
	}
	
	//新建工厂对象
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String factoryInsert(){
		return "basicinfo/factory/jFactoryCreate.jsp";
	}
	//将工厂对象插入到数据库
	@RequestMapping("/basicinfo/factory/insert.action")
	public String factoryINSERT(Factory fac){
		System.out.println(fac);
		factoryService.insert(fac);
		return "redirect:list.action";
	}
	
	//将选中的工厂对象删除
	@RequestMapping("/basicinfo/factory/deletebatch.action")
	public String factoryDelete(HttpServletRequest request){
		//String id = request.getParameter("id");
		String[] uuid = request.getParameterValues("id");
		for (int i = 0; i < uuid.length; i++) {
			factoryService.delete(uuid[i]);
		}
		return "redirect:list.action";
	}
	//单击下载,将数据库文件转换为文档格式,并下载到客户端本地
	@RequestMapping("/basicinfo/factory/print.action")
	public void printFactory(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		//创建一个工作浦
		Workbook wb = new HSSFWorkbook();
		//创建sheet对象
		Sheet sheet = wb.createSheet();
		int rowNo = 0;//行号
		int colNo = 0;//列号
		Row nRow = null;//创建行对象
		Cell cell = null;//创建格子对象
		nRow = sheet.createRow(rowNo);//初始化对象
		sheet.setColumnWidth(0, 30*256);//设置第一列宽度为30,sheet总共有256行
		nRow.setHeightInPoints(40);
		sheet.addMergedRegion(new CellRangeAddress(rowNo, colNo, 0, 6));
		cell = nRow.createCell(0);//初始化格子对象
		cell.setCellValue("生产厂商信息表");//向格子里传值
		cell.setCellStyle(this.bigtitleStyle(wb));
		rowNo++;
		//小标题
		String[] title = new String[]{"厂商全称","缩写","联系人","电话","手机","传真","备注"};
		nRow = sheet.createRow(rowNo);
		rowNo++;
		nRow.setHeightInPoints(30);
		for (int i = 0; i < title.length; i++) {
			cell = nRow.createCell(i);//创建格子对象
			cell.setCellValue(title[i]);
			cell.setCellStyle(this.titleStyle(wb));
		}
		//将厂商数据写出
		List<Factory> list = factoryService.findFactory();//获取所有数据
		for (int j = 0; j < list.size(); j++) {
			colNo=0;
			nRow = sheet.createRow(rowNo++);
			nRow.setHeightInPoints(20);
			Factory f = list.get(j);
			//将数据写入
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getFullName());
			cell.setCellStyle(this.FactoryStyle(wb));
			
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getFactoryName());
			cell.setCellStyle(this.FactoryStyle(wb));
			
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getContractor());
			cell.setCellStyle(this.FactoryStyle(wb));
			
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getPhone());
			cell.setCellStyle(this.FactoryStyle(wb));
			
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getMobile());
			cell.setCellStyle(this.FactoryStyle(wb));
			
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getFax());
			cell.setCellStyle(this.FactoryStyle(wb));
			
			cell = nRow.createCell(colNo++);
			cell.setCellValue(f.getCnote());
			cell.setCellStyle(this.FactoryStyle(wb));
		}
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建流对象
		wb.write(bos);
		//下载类
		DownloadUtil du = new DownloadUtil();
		du.download(bos, response, "生产厂商信息表.xlsx");
	}
	//厂商信息
	private CellStyle FactoryStyle(Workbook wb) {
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(CellStyle.ALIGN_CENTER);//左右居中
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//上下居中
		Font font = wb.createFont();//设置字体样式
		font.setFontName("正文");//字体类型
		font.setFontHeightInPoints((short) 12);//字体高度
		cs.setFont(font);
		
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		return cs;
	}
	private CellStyle titleStyle(Workbook wb) {
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(CellStyle.ALIGN_CENTER);//左右居中
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//上下居中
		Font font = wb.createFont();//设置字体样式
		font.setFontName("正文");//字体类型
		font.setFontHeightInPoints((short) 15);//字体高度
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		return cs;
	}

	
	//大标题格子样式
	private CellStyle bigtitleStyle(Workbook wb) {
		CellStyle cs = wb.createCellStyle();
		cs.setAlignment(CellStyle.ALIGN_CENTER);//左右居中
		cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//上下居中
		Font font = wb.createFont();//设置字体样式
		font.setFontName("黑体");//字体类型
		font.setFontHeightInPoints((short) 30);//字体高度
		return cs;
	}

	@RequestMapping("list.do")
	public String showView(){
		return "basicinfo/factory/jFactoryList.jsp";
	}
	//进行重定向功能,返回显示工厂信息的页面
	@RequestMapping("login.do")
	public String login(){
		return "/basicinfo/factory/list.action";
	}
	
}
