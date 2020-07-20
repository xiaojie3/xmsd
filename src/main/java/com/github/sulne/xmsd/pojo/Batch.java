package com.github.sulne.xmsd.pojo;

import java.util.List;

public class Batch<M> {
	private String operational;
	private List<M> models;
	public String getOperational() {
		return operational;
	}
	public void setOperational(String operational) {
		this.operational = operational;
	}
	public List<M> getModels() {
		return models;
	}
	public void setModels(List<M> models) {
		this.models = models;
	}
	
}
