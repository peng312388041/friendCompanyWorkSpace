package com.peng;

public class Test implements Runnable {

	@Override
	public void run() {
		int i=1;
		while (true) {
			System.out.println("哈哈............."+i++);
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
