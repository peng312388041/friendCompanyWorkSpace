package com.e6mall.utils.alipay;

import java.util.Iterator;
import java.util.Set;

import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.model.Setting;

public class ConfirmSendUrl {
	public String Confirm(Orders orders) throws Exception {
		String ItemUrl = "";
		String paygateway = "https://www.alipay.com/cooperate/gateway.do?"; //支付接口(不可修改)
		String service = "send_goods_confirm_by_platform"; //确认发货接口(不可修改)
		String sign_type = "MD5"; //签名方式(不可修改)
		String input_charset = "UTF-8";//页面编码（不可以修改）
		//partner和key提取方法：登陆签约支付宝账户--->点击“商家服务”就可以看到
		String partner = ""; //支付宝合作伙伴id (账户内提取)
		String key = ""; //支付宝安全校验码(账户内提取)
		
		Paymode paymode = orders.getPaymode();
		if (null != paymode && (paymode.getPmtype().equals("alipay") || paymode.getPmtype().equals("alipay"))) {
			Set set = paymode.getSettings();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Setting setting = (Setting)it.next();
				if (setting.getProperty().equals("partner"))
					partner = setting.getValue();
				if (setting.getProperty().equals("key"))
					key = setting.getValue();
			}
		}
		

		//******以上是账户信息，以下是商品信息**************************
		String trade_no = orders.getCode(); //该交易在支付宝系统中的交易流水号
		String transport_type = "";
		//String logistics_name = "";  //物流公司名称，例如：中通快递
		//String invoice_no = "";  //物流发货单号（根据自己的信息填写）
		transport_type = "EXPRESS"; //发货时的运输类型，一般有：平邮、快递、EMS
		ItemUrl = PaymentUrl.CreateUrl1(paygateway, service, sign_type,
				input_charset, partner, key, trade_no,transport_type);

		
		/*使用解析类对结果行解析，如果出现问题请注销解析类*/
		//response.sendRedirect(ItemUrl);
		//System.out.println(ItemUrl);
		/*解析XML
		  您可以在这里解析后获取，然后写入您们的后台数据库*/
		Dom4j dom4 = new Dom4j();
		String result = dom4.DomXml(ItemUrl);
		//做完解析后您可以完成页面的跳转（目前这里通过重定向完成）
		System.out.println(result);
		//response.sendRedirect("http://wow.alipay.com");
		return result;
	}
}
