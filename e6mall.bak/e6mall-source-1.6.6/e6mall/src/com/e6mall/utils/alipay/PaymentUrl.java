package com.e6mall.utils.alipay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.model.Setting;

public class PaymentUrl {
	
	public String getUrlparam(Orders orders, String preUrl) {
		String urlparam = "";
		
		String paygateway =	"";		//支付接口
		String service = "";		//接口类型
		String sign_type = "";
		String input_charset = "utf-8";    
		String payment_type = "1";
		String partner = "";		//支付宝合作伙伴id (账户内提取)
		String key = "";			//支付宝安全校验码(账户内提取)
		String seller_email = "";	//卖家支付宝帐户
		
		String out_trade_no = orders.getCode();	//商户网站订单号，此处直接使用了订单ID
		String subject = orders.getSubject();		//商品名称
		String price = orders.getActamount().toString();	//商品的单价，在此为订单的总价
		String quantity = "1";		//商品的数量，在此默认为1
		String logistics_type = "EXPRESS";	//物流类型。根据物流类型枚举列表，它只有固定的几个值可以选择：EXPRESS、POST、EMS。
		String logistics_fee = orders.getLogicost().toString();		//物流费用。可以为0元，格式是小数点最多两位。
		System.out.println(logistics_fee);
		String logistics_payment = "BUYER_PAY";	//物流支付类型。根据物流类型枚举列表，它只有固定的几个值可以选择：SELLER_PAY、BUYER_PAY。
		
		String body = orders.getBody();		//商品描述。说的更为形象一些，它是该笔订单的备注、明细、描述等。
		
		String return_url = preUrl + "/alipay_return.htm";	//返回URL。交易付款完成以后，当前页面自动跳转返回商户的网址。该商户的网址即是该参数指定的URL。
		String notify_url = preUrl + "/alipay_notify.htm";	//通知URL。一旦该交易的交易状态有变动，支付宝服务器会自动调用该参数指定的URL的页面文件，并让其程序自动执行里面的数据代码。
		
		String show_url = preUrl + "/member/orderitems.htm?os=" + orders.getId();	//商品展示网址。它是商户的订单详细的一个快速入口链接。以方便买家可以在商家网站中查找自己的下单信息。
		String buyer_email = "";	//买家默认支付宝账号。当设置好该参数时，到达收银台页面后，支付宝账号的填写框被默认填入了该参数的值。
		String discount = "0";	//折扣。商家打折的金额。运算规则是：price* quantity+ logistics_fee + discount。discount当为负数时，才具有折扣的作用。该参数是实际的数字，非百分比。
		
		Paymode paymode = orders.getPaymode();
		if (null != paymode && (paymode.getPmtype().equals("alipay") || paymode.getPmtype().equals("alipay"))) {
			Set set = paymode.getSettings();
			Iterator it = set.iterator();
			while(it.hasNext()) {
				Setting setting = (Setting)it.next();
				if (setting.getProperty().equals("paygateway"))
					paygateway = setting.getValue();
				if (setting.getProperty().equals("service"))
					service = setting.getValue();
				if (setting.getProperty().equals("sign_type"))
					sign_type = setting.getValue();
				if (setting.getProperty().equals("partner"))
					partner = setting.getValue();
				if (setting.getProperty().equals("key"))
					key = setting.getValue();
				if (setting.getProperty().equals("seller_email"))
					seller_email = setting.getValue();
			}
		}
		
		if (!paygateway.equals("") && !service.equals("") && !sign_type.equals("") && !out_trade_no.equals("") && !partner.equals("") && 
				!key.equals("") && !seller_email.equals("")) {
			if (null != orders.getStaddress()) {
				String receive_name = orders.getStaddress().getName();			//收货人姓名
				String receive_address = orders.getStaddress().getAddress();	//收货人地址。
				String receive_zip = orders.getStaddress().getPostcode();		//收货人邮编。
				String receive_phone = orders.getStaddress().getTelephone();	//收货人联系电话。
				String receive_mobile = orders.getStaddress().getMobile();		//收货人手机。
				
				urlparam = PaymentUrl.CreateUrl(paygateway, service, sign_type, out_trade_no, input_charset, partner,
					key, seller_email, body, subject, price, quantity, show_url, payment_type, discount,
					logistics_type, logistics_fee, logistics_payment, return_url, notify_url,
					buyer_email, receive_name, receive_address, receive_zip, receive_phone, receive_mobile);
			} else {//不需要收货人信息
				urlparam = PaymentUrl.CreateUrl(paygateway, service, sign_type, out_trade_no, input_charset, partner,
						key, seller_email, body, subject, price, quantity, show_url, payment_type, discount,
						logistics_type, logistics_fee, logistics_payment, return_url, notify_url,
						buyer_email, "", "", "", "", "");
			}
			
		}
		
		return urlparam;
	}

	public static String CreateUrl(String paygateway, String service,
			String sign_type, String out_trade_no, String input_charset,
			String partner, String key, String seller_email, String body,
			String subject, String price, String quantity, String show_url,
			String payment_type, String discount, String logistics_type,
			String logistics_fee, String logistics_payment, String return_url, String notify_url,
			String buyer_email, String receive_name, String receive_address, String receive_zip,
			String receive_phone, String receive_mobile) {
		// String notify_url,需要的请把参数加入以上的createurl
		Map params = new HashMap();
		params.put("service", service);
		params.put("out_trade_no", out_trade_no);
		params.put("show_url", show_url);
		params.put("quantity", quantity);
		params.put("partner", partner);
		params.put("payment_type", payment_type);
		params.put("discount", discount);
		params.put("body", body);
		params.put("notify_url", notify_url);
		params.put("price", price);
		params.put("return_url", return_url);
		params.put("seller_email", seller_email);
		params.put("logistics_type", logistics_type);
		params.put("logistics_fee", logistics_fee);
		params.put("logistics_payment", logistics_payment);
		params.put("subject", subject);
		params.put("_input_charset", input_charset);
		params.put("buyer_email", buyer_email);
		params.put("receive_name", receive_name);
		params.put("receive_address", receive_address);
		params.put("receive_zip", receive_zip);
		params.put("receive_phone", receive_phone);
		params.put("receive_mobile", receive_mobile);
		String prestr = "";

		prestr = prestr + key;
		// System.out.println("prestr=" + prestr);

		String sign = Md5Encrypt.md5(getContent(params, key));

		String parameter = "";
		parameter = parameter + paygateway;
		// System.out.println("prestr=" + parameter);
		List keys = new ArrayList(params.keySet());
		for (int i = 0; i < keys.size(); i++) {
			String value = (String) params.get(keys.get(i));
			if (value == null || value.trim().length() == 0) {
				continue;
			}
			try {
				parameter = parameter + keys.get(i) + "="
						+ URLEncoder.encode(value, input_charset) + "&";
			} catch (UnsupportedEncodingException e) {

				e.printStackTrace();
			}
		}

		parameter = parameter + "sign=" + sign + "&sign_type=" + sign_type;
		System.out.println(parameter);

		return parameter;

	}

	/*
	 * 不需要物流信息的
	 */
    public static String CreateUrl1(String paygateway,String service,String sign_type,
    		String input_charset,String partner,String key,
    		String trade_no,String transport_type) {
        Map params = new HashMap();
        params.put("service", service);
        params.put("partner", partner);
        params.put("trade_no", trade_no);
        params.put("transport_type", transport_type);
        params.put("_input_charset", input_charset);

        String prestr = "";

        prestr = prestr + key;
       // System.out.println("prestr=" + prestr);

        String sign = Md5Encrypt.md5(getContent(params, key));

        String parameter = "";
        parameter = parameter + paygateway;

        List keys = new ArrayList(params.keySet());
        for (int i = 0; i < keys.size(); i++) {
          	String value =(String) params.get(keys.get(i));
            if(value == null || value.trim().length() ==0){
            	continue;
            }
            try {
                parameter = parameter + keys.get(i) + "="
                    + URLEncoder.encode(value, input_charset) + "&";
            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();
            }
        }

        parameter = parameter + "sign=" + sign + "&sign_type=" + sign_type;
        System.out.println(parameter);
        
        return parameter;

    }
    
    
  //需要物流信息的
    public static String CreateUrl2(String paygateway,String service,String sign_type,
    		String input_charset,String partner,String key,
    		String trade_no,String logistics_name,String invoice_no,String transport_type) {
        Map params = new HashMap();
        params.put("service", service);
        params.put("partner", partner);
        params.put("trade_no", trade_no);
        params.put("logistics_name", logistics_name);
        params.put("invoice_no", invoice_no);
        params.put("transport_type", transport_type);
        params.put("_input_charset", input_charset);

        String prestr = "";

        prestr = prestr + key;
       // System.out.println("prestr=" + prestr);

        String sign = Md5Encrypt.md5(getContent(params, key));

        String parameter = "";
        parameter = parameter + paygateway;

        List keys = new ArrayList(params.keySet());
        for (int i = 0; i < keys.size(); i++) {
          	String value =(String) params.get(keys.get(i));
            if(value == null || value.trim().length() ==0){
            	continue;
            }
            try {
                parameter = parameter + keys.get(i) + "="
                    + URLEncoder.encode(value, input_charset) + "&";
            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();
            }
        }

        parameter = parameter + "sign=" + sign + "&sign_type=" + sign_type;

        return parameter;

    }

	private static String getContent(Map params, String privateKey) {
		List keys = new ArrayList(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		boolean first = true;
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = (String) params.get(key);
			if (value == null || value.trim().length() == 0) {
				continue;
			}
			if (first) {
				prestr = prestr + key + "=" + value;
				first = false;
			} else {
				prestr = prestr + "&" + key + "=" + value;
			}
		}
		return prestr + privateKey;
	}
}
