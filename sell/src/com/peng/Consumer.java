package com.peng;

import java.util.List;

public class Consumer implements Runnable {

	@Override
	public void run() {
		while (true) {
			synchronized (Constants.goodsList) {
				if (Constants.getCount() <= 0) {

					try {
						System.out.println("容器已空，等待中.............");
						Constants.goodsList.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (Constants.getCount() > 0) {
					synchronized (Constants.goodsList) {
						consume();
						try {
							Thread.sleep(2000);
							System.out.println("消费完毕," + "还剩"
									+ Constants.getCount() + "个");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						synchronized (Constants.goodsList) {
							if (Constants.getCount() == 4)
								Constants.goodsList.notify();
						}
					}
				}
			}

		}
	}

	public void consume() {
		List<Goods> list = Constants.goodsList;
		list.remove(list.size() - 1);
	}
}
