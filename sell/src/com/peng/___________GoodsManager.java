package com.peng;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ___________GoodsManager {
 
	private Map<String, List>  goodsMap;
	
	//返回商品
	private List getGoodsCount(String name)
	{
		return getGoodsMap().get(name);
	}
	
	//定义生产者
	private Producer producer;
	
	//定义消费者
	private Consumer consumer;
	
	public void produce(Producer producer ,String name)
	{
		
	}
	
	public void Consumer()
	{
		
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Map<String, List> getGoodsMap() {
		return goodsMap;
	}

	public void setGoodsMap(Map<String, List> goodsMap) {
		this.goodsMap = goodsMap;
	}
	
	
 
}
