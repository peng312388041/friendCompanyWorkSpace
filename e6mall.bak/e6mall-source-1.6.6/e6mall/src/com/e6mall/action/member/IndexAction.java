package com.e6mall.action.member;

import com.e6mall.action.BaseAction;

public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 722295243083353616L;

	public String execute() throws Exception {
		getMsession();
		return SUCCESS;
	}
}
