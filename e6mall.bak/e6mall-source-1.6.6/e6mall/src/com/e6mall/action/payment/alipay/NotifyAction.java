package com.e6mall.action.payment.alipay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.model.Setting;
import com.e6mall.utils.alipay.CheckURL;
import com.e6mall.utils.alipay.SignatureHelper_return;

/*
 * 名称：付款过程中服务器通知页面
 * 功能：服务器通知返回，不会出现掉单情况，推荐使用
 */
public class NotifyAction extends BaseAction {
	private static final long serialVersionUID = 2440790405104504776L;
	private String result = "failed";

	public String execute() throws Exception {
		
		String out_trade_no = request.getParameter("out_trade_no"); // 订单号
		Orders orders = sorders.findByCode(out_trade_no);
		if (null != orders) {
			Paymode paymode = orders.getPaymode();
			if (null != paymode && (paymode.getPmtype().equals("alipay"))) {
				String partner = ""; // partner合作伙伴id（必须填写）
				String key = ""; // partner 的对应交易安全校验码（必须填写）

				Set set = paymode.getSettings();
				Iterator it = set.iterator();
				while (it.hasNext()) {
					Setting setting = (Setting) it.next();
					if (setting.getProperty().equals("partner"))
						partner = setting.getValue();
					if (setting.getProperty().equals("key"))
						key = setting.getValue();
				}
				
				String alipayNotifyURL = "http://notify.alipay.com/trade/notify_query.do?"
					+ "partner="
					+ partner
					+ "&notify_id="
					+ request.getParameter("notify_id");
				String sign = request.getParameter("sign");
				
				// 获取支付宝ATN返回结果，true是正确的订单信息，false 是无效的
				String responseTxt = CheckURL.check(alipayNotifyURL);
				System.out.println("responseTxt: "+responseTxt);
				
				Map params = new HashMap();
				// 获得POST 过来参数设置到新的params中
				Map requestParams = request.getParameterMap();
				for (Iterator iter = requestParams.keySet().iterator(); iter
						.hasNext();) {
					String name = (String) iter.next();
					String[] values = (String[]) requestParams.get(name);
					String valueStr = "";
					for (int i = 0; i < values.length; i++) {
						valueStr = (i == values.length - 1) ? valueStr
								+ values[i] : valueStr + values[i] + ",";
					}
					System.out.println(name+" : "+valueStr);
					params.put(name, valueStr);
				}
				
				String mysign = SignatureHelper_return.sign(params, key);
				// 打印，收到消息比对sign的计算结果和传递来的sign是否匹配
				System.out.println(mysign+"--------------------"+sign);
				
				String trade_status = orders.getStatus();
				if (mysign.equals(request.getParameter("sign"))	&& responseTxt.equals("true")) {
					if(trade_status.equals("WAIT_BUYER_PAY")){
						//交易已创建，等待买家付款。
						//在这里可以写入数据处理,
					}else if(trade_status.equals("WAIT_SELLER_SEND_GOODS")){
						//买家付款成功，等待卖家发货
						//在这里可以写入数据处理,
					}else if(trade_status.equals("WAIT_BUYER_CONFIRM_GOODS")){
						//卖家已发货， 等待买家确认
						//在这里可以写入数据处理,
					}else if(trade_status.equals("TRADE_FINISHED")){
						//交易成功结束
						//在这里可以写入数据处理,
					}
				}
			}
		}
		return ERROR;
	}
}
