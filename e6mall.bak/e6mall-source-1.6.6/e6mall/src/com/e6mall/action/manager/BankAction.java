package com.e6mall.action.manager;

import java.util.Date;

public class BankAction extends BaseAction {
	private static final long serialVersionUID = 8658665783932666545L;
	private Date min;
	private Date max;
	private Double total_balance;

	public String execute() throws Exception {
		total_balance = sbrunacc.getTotalBalance(min, max);
		return SUCCESS;
	}

	public Date getMin() {
		return min;
	}

	public void setMin(Date min) {
		this.min = min;
	}

	public Date getMax() {
		return max;
	}

	public void setMax(Date max) {
		this.max = max;
	}

	public Double getTotal_balance() {
		return total_balance;
	}

	public void setTotal_balance(Double totalBalance) {
		total_balance = totalBalance;
	}
}
