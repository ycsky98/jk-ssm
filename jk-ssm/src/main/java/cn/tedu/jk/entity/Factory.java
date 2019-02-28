package cn.tedu.jk.entity;

public class Factory {
	private String id;//id编码
	private String fullName;//全称
	private String factoryName;//简称
	private String contractor;//联系人
	private String phone;//电话
	private String mobile;//手机
	private String fax;//传真
	private String cnote;//备注
	private Integer orderNo;//排序号
	private Integer state;//状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getContractor() {
		return contractor;
	}
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCnote() {
		return cnote;
	}
	public void setCnote(String cnote) {
		this.cnote = cnote;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Factory [id=" + id + ", fullName=" + fullName + ", factoryName=" + factoryName + ", contractor="
				+ contractor + ", phone=" + phone + ", mobile=" + mobile + ", fax=" + fax + ", cnote=" + cnote
				+ ", orderNo=" + orderNo + ", state=" + state + "]";
	}
	
}