package com.e6mall.action;

import com.e6mall.model.Comments;
import com.e6mall.model.Goods;
import com.opensymphony.xwork2.ActionContext;

public class CommentsSubmitAction extends BaseAction {
	private static final long serialVersionUID = 1629894168019221811L;
	private String gs;
	private String content;
	private String validateCode;
	private String result;

	public String execute() throws Exception {
		String verifyCode = (String) ActionContext.getContext().getSession().get("VerifyCode");
		if (null != verifyCode && verifyCode.equals(validateCode)) {
			Goods goods = sgoods.findById(gs);
			if (null != goods) {
				String status = "audit"; //模拟数据，要从配置表中读取 TODO
				Comments comments = new Comments();
				comments.setId(getUuid());
				comments.setGoods(goods);
				comments.setContent(content);
				if (null != getMsession()) {
					comments.setMember(getMsession());
				}
				comments.setCdate(getTimestamp());
				comments.setStatus(status);
				scomments.save(comments);
				if (null != status && !status.equals("normal")) {
					result = "评论提交成功，等待审核";
				} else {
					result = "评论提交成功";
				}
			} else {
				result = "信息错误";
			}
		} else {
			result = "验证码错误";
		}
		return SUCCESS;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
