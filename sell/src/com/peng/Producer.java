package com.peng;

public class Producer implements Runnable {

	@Override
	public void run() {

		while (true) {
			// 有5个时等待
			synchronized (Constants.goodsList) {
				if (Constants.getCount() >= 5) {

					try {
						System.out.println("窗口已满，等待中............");
						Constants.goodsList.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {

					produce();
					try {
						Thread.sleep(2000);
						System.out.println("生产成功，当前共有" + Constants.getCount()
								+ "个");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Constants.goodsList.notify();
				}
			}
		}
	}

	public void produce() {
		Goods goods = new Goods();
		goods.setId(Constants.generateId());
		Constants.goodsList.add(goods);
	}
}