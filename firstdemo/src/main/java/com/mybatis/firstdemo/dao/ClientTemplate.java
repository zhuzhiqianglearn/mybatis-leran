package com.mybatis.firstdemo.dao;


import java.sql.Timestamp;

/**
 * 
 * 实体类
 * <b>功能：</b>ClientTemplateDao<br>
 * <b>作者：</b>CodeGenerater<br>
 * <b>日期：</b>2019-02-25 16:12:10<br>
 * <b>版权所有：<b>天瑞兴隆<br>
 */
public class ClientTemplate {

	//属性部分
	private int id; //主键
	private int clientId; //委单方id
	private String nickName; //委单方昵称
	private String chineseName; //中文名称
	private String fieldName; //元素名称
	private String fieldValue; //元素的值
	private int type; //模板类型 1：催收方对账模板 2：催收方减免模板3：平台委单方下载模板4：平台委单方减免模板
	private int status; //模板使用状态 1：使用 2：停用（历史模板）
	private String ipAddress; //请求机器的id
	private int createId; //创建人id
	private String createName; //创建人姓名
	private java.sql.Timestamp createTime; //
	private String createTimeStr; //
	private String process; //

	public int getId() {
		return id;
	}

	public ClientTemplate setId(int id) {
		this.id = id;
		return this;
	}

	public int getClientId() {
		return clientId;
	}

	public ClientTemplate setClientId(int clientId) {
		this.clientId = clientId;
		return this;
	}

	public String getNickName() {
		return nickName;
	}

	public ClientTemplate setNickName(String nickName) {
		this.nickName = nickName;
		return this;
	}

	public String getChineseName() {
		return chineseName;
	}

	public ClientTemplate setChineseName(String chineseName) {
		this.chineseName = chineseName;
		return this;
	}

	public String getFieldName() {
		return fieldName;
	}

	public ClientTemplate setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public ClientTemplate setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
		return this;
	}

	public int getType() {
		return type;
	}

	public ClientTemplate setType(int type) {
		this.type = type;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public ClientTemplate setStatus(int status) {
		this.status = status;
		return this;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public ClientTemplate setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
		return this;
	}

	public int getCreateId() {
		return createId;
	}

	public ClientTemplate setCreateId(int createId) {
		this.createId = createId;
		return this;
	}

	public String getCreateName() {
		return createName;
	}

	public ClientTemplate setCreateName(String createName) {
		this.createName = createName;
		return this;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public ClientTemplate setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public ClientTemplate setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
		return this;
	}

	public String getProcess() {
		return process;
	}

	public ClientTemplate setProcess(String process) {
		this.process = process;
		return this;
	}
}

