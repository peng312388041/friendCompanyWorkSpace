package com.e6mall.action;

public class ScartAction extends BaseAction {
	private static final long serialVersionUID = -4782570611100734818L;

	public String execute() throws Exception {
		GlobalChcontent(map);
		session.put("url","my_sorders.htm");
		return SUCCESS;
	}
}
