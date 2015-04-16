package com.e6mall.action.payment.alipay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Bank;
import com.e6mall.model.Brunacc;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.model.Setting;
import com.e6mall.utils.COrders;
import com.e6mall.utils.Notice;
import com.e6mall.utils.alipay.CheckURL;
import com.e6mall.utils.alipay.SignatureHelper_return;

public class ReturnAction extends BaseAction {
	private static final long serialVersionUID = 685687646492891157L;
	private Notice notice = new Notice();

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
				System.out.println("mysign: "+mysign);

				// 打印，收到消息比对sign的计算结果和传递来的sign是否匹配
				System.out.println(mysign+"--------------------"+sign);

				if (mysign.equals(request.getParameter("sign"))
						&& responseTxt.equals("true")) {

					System.out.println("success");
					System.out.println(params.get("body"));// 测试时候用，可以删除
					System.out.println(params.get("body"));
					System.out.println("显示订单信息");
					System.out.println(responseTxt);

					// 如果您申请了支付宝的购物卷功能，请在返回的信息里面不要做金额的判断，否则会出现校验通不过，出现调单。如果您需要获取买家所使用购物卷的金额,
					// 请获取返回信息的这个字段discount的值，取绝对值，就是买家付款优惠的金额。即
					// 原订单的总金额=买家付款返回的金额total_fee +|discount|.

					//支付成功，更新订单状态
					orders.setStatus(COrders.WAIT_SELLER_SEND_GOODS);
					sorders.merge(orders);
					
					notice.setStatus(true);
					notice.setCode(request.getParameter("trade_status"));
					notice.setTitle("提示：");
					notice.setBody("支付成功。");
					
				} else {
					System.out.println("fail");
					
					notice.setStatus(false);
					notice.setCode(request.getParameter("trade_status"));
					notice.setTitle("错误：");
					notice.setBody("支付失败。");
				}

			} else {
				notice.setStatus(false);
				notice.setCode(request.getParameter("trade_status"));
				notice.setTitle("错误：");
				notice.setBody("非支付宝支付的订单。");
			}
		} else {	//无持久化订单，充值
			Brunacc brunacc = sbrunacc.findById(out_trade_no);
			if (null != brunacc) {
				Paymode paymode = brunacc.getPaymode();
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
					System.out.println("mysign: "+mysign);
	
					// 打印，收到消息比对sign的计算结果和传递来的sign是否匹配
					System.out.println(mysign+"--------------------"+sign);
	
					if (mysign.equals(request.getParameter("sign"))
							&& responseTxt.equals("true")) {
	
						System.out.println("success");
						System.out.println(params.get("body"));// 测试时候用，可以删除
						System.out.println(params.get("body"));
						System.out.println("显示订单信息");
						System.out.println(responseTxt);
	
						// 如果您申请了支付宝的购物卷功能，请在返回的信息里面不要做金额的判断，否则会出现校验通不过，出现调单。如果您需要获取买家所使用购物卷的金额,
						// 请获取返回信息的这个字段discount的值，取绝对值，就是买家付款优惠的金额。即
						// 原订单的总金额=买家付款返回的金额total_fee +|discount|.
	
						//支付成功，更新资金账户流水项状态
						brunacc.setStatus("ok");
						
						Bank bank = brunacc.getBank();
						Double balance = bank.getBalance() + brunacc.getPayin();
						bank.setBalance(balance);
						sbank.merge(bank);
						
						sbrunacc.merge(brunacc);
											
						notice.setStatus(true);
						notice.setCode(request.getParameter("trade_status"));
						notice.setTitle("提示：");
						notice.setBody("充值成功。");
						
					} else {
						System.out.println("fail");
						
						notice.setStatus(false);
						notice.setCode(request.getParameter("trade_status"));
						notice.setTitle("错误：");
						notice.setBody("充值失败。");
					}
				}
			} else {
				notice.setStatus(false);
				notice.setCode(request.getParameter("trade_status"));
				notice.setTitle("警告：");
				notice.setBody("非常操作，充值记录不存在。");
			}
		}
		return SUCCESS;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
}
