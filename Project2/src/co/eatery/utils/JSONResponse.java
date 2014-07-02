package co.prvn.eatery.utils;

import java.util.HashMap;

public class JSONResponse {

	private String status; //SUCCESS, ERROR
	private String msg;
	private HashMap<String, Object> data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	public void setObject (String key, Object value){
		if(data == null){
			data = new HashMap<String, Object>();
		}
		data.put(key, value);
	}
	
}
