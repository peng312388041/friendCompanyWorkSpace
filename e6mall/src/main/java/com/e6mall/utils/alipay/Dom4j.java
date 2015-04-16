package com.e6mall.utils.alipay;

import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4j {
	String filepath = "";

	public String DomXml(String filepath) throws Exception {
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new URL(filepath).openStream());
		//暂时没有判断未支付解析标准，可以在dom4j获取alipay节点，判断is_success的标识，是F说明已经确认发货或者未支付就发货
		//解析request列表下的信息
		List<Node> nodeList = doc.selectNodes("//request/*");
		StringBuffer buf = new StringBuffer();
		for (Node node : nodeList) {
			buf.append("<html><p>");
			buf.append(node.getName()).append("=").append(node.getText())
					.append("<html><p>");
		}
		//解析response列表下的订单信息 
		List<Node> nodeList1 = doc.selectNodes("//response/tradeBase/*");
		StringBuffer buf1 = new StringBuffer();
		for (Node node : nodeList1) {
			buf1.append("<html><p>");
			//截取部分不需要解析的信息
			//if(!node.getName().equals("flag_trade_locked")&&!node.getName().equals("use_coupon")){
				//将解析后的数据存入字符流
				buf1.append(node.getName()).append("=").append(node.getText())
				.append("<html><p>");
			//}				
		}
		// System.out.println(buf.toString());
		return "request信息：" + buf.toString()+ 
				"response信息：" + buf1.toString();

	}

	
	public static void main(String[] args) throws Exception {
		//dom4j dom = new dom4j();
		//String sss = dom
		//		.dd("https://www.alipay.com/cooperate/gateway.do?service=single_trade_query&partner=2088002029290264&_input_charset=utf-8&out_trade_no=237&sign=abaab98dbff75a3712ec7a69e295a80b&sign_type=MD5");
		//System.out.println(sss);

	}
}
