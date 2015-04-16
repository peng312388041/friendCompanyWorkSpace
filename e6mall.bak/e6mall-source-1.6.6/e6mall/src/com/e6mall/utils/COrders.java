package com.e6mall.utils;

public class COrders {
	public final static String YES = "yes";			//是
	public final static String NO = "no";			//否
	public final static String CANCEL = "cancel";	//订单取消
	public final static String NORMAL = "normal";	//正常
	public final static String DSTB = "dstb";		//正在配货
	public final static String DELIVERY = "delivery";//已发货
	public final static String SIGNIN = "signin";	//已签收
	
	public final static String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";	//交易创建
	public final static String WAIT_SELLER_SEND_GOODS = "WAIT_SELLER_SEND_GOODS";	//买家付款成功
	public final static String WAIT_BUYER_CONFIRM_GOODS = "WAIT_BUYER_CONFIRM_GOODS";	//卖家发货成功
	public final static String TRADE_FINISHED = "TRADE_FINISHED";	//交易成功结束
	public final static String TRADE_CLOSED = "TRADE_CLOSED";		//交易关闭
	public final static String MODIFY_TRADE_TOTALFEE = "MODIFY_TRADE_TOTALFEE";		//修改交易价格
	
	//购物车
    public final static String NOTICE_NOPRICE_CODE = "CART_NOT_PRICE";
    public final static String NOTICE_NOPRICE_TITLE = "商品价格错误";
    public final static String NOTICE_NOPRICE_BODY = "商品没有价格，或价格错误。";
}
