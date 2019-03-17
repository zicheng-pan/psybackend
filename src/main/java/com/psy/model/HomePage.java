package com.psy.model;

import java.util.Map;

import com.psy.tool.Result;

public class HomePage<E> {
	private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Map<String, Result> result;

	public Map<String, Result> getResult() {
		return result;
	}

	public void setResult(Map<String, Result> result) {
		this.result = result;
	}
	
}
