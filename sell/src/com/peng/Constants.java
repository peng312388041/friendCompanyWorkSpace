package com.peng;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	private static int id = 1;
	public static List<Goods> goodsList = new ArrayList<Goods>();

	public static int generateId() {
		return id++;
	}

	public static int getCount() {
		return goodsList.size();
	}
}
