package com.github.sulne.xmsd.pojo;

import java.io.Serializable;

public class WebLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;//编号
    private String url;//地址
    private String method;//方法
    private String ip;//IP地址
    private String type;//请求类型
    private String parameters;//传入参数
    private String ret;//返回值
    private String time;//时间
    private String userId;//用户ID
    private String cost;//耗时
    
    public WebLog() {}
    
    public WebLog(String id, String url, String method, String ip, String type, String parameters, String time,
			String userId) {
		super();
		this.id = id;
		this.url = url;
		this.method = method;
		this.ip = ip;
		this.type = type;
		this.parameters = parameters;
		this.time = time;
		this.userId = userId;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "WebLog [id=" + id + ", url=" + url + ", method=" + method + ", ip=" + ip + ", type=" + type
				+ ", parameters=" + parameters + ", ret=" + ret + ", time=" + time + ", userId=" + userId + ", cost="
				+ cost + "]";
	}
    
}