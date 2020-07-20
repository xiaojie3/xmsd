package com.github.sulne.xmsd.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sudoku {
	Logger log = LoggerFactory.getLogger(Sudoku.class);
	Integer grid = 3;
	Map<Integer, List<Integer>> row;
	Map<Integer, List<Integer>> column;
	Map<Integer, List<Integer>> block;
	Map<Integer, List<Integer>> candidates;

	public Sudoku() {
		row = new HashMap<>();
		column = new HashMap<>();
		block = new HashMap<>();
		candidates = new HashMap<>();
		Integer[] [] temp = {
				 {9,1,0,0,0,0,0,6,0}
				,{0,0,0,0,0,5,0,0,0}
				,{0,5,0,0,0,3,0,9,0}
				,{0,0,2,0,9,0,4,0,0}
				,{0,7,9,0,0,0,0,0,0}
				,{0,3,0,0,6,4,0,0,0}
				,{7,0,0,0,0,0,0,5,8}
				,{0,0,0,0,0,1,0,0,0}
				,{0,0,0,2,5,0,3,0,4}
			};
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < 9; j++) {
			list.add(0);
		}
		for (int i = 0; i < new Double(Math.pow(grid, 2)).intValue(); i++) {
			row.put(i, Arrays.asList(temp[i]));
		}
		/*
		 * for (int i = 1; i <= new Double(Math.pow(grid, 4)).intValue(); i ++)
		 * { candidates.put(i, list); }
		 */
	}

	@Test
	public void test() {
		this.start();
		if (this.add("r1c1", 1)) {
			for (int i = 0; i < new Double(Math.pow(grid, 2)).intValue(); i++) {
				System.out.println(row.get(i).toString());
			}
		} else {
			System.out.println(11);
		}
	}

	public void start() {

	}
	
	private Boolean add(String td, Integer value) {
		Map<String, Integer> wz = this.jx(td);
		if (null == wz) {
			System.err.println("error");
			return false;
		}
		List<Integer> rowList = row.get(wz.get("R"));
		for (Integer integer : rowList) {
			if (integer != wz.get("R")) {
				if (integer.equals(value)) {
					System.out.println("该值不唯一");
					value = (value > 0) ? -value : value;
				}
			}
		}
		rowList.set(wz.get("C"), value);
		row.put(wz.get("R"), rowList);
		return true;
	}

	private Map<String, Integer> jx(String str) {
		Map<String, Integer> map = new HashMap<>();
		str = str.toUpperCase();
		if (4 == str.length()) {
			int i = str.indexOf("R");
			System.out.println(i);
			if (i == 0 || i == 2) {
				map.put("R", (str.charAt(i + 1) - '0') - 1);
				int j = str.indexOf("C");
				System.out.println(j);
				if (j == 0 || j == 2) {
					map.put("C", (str.charAt(j + 1) - '0') - 1);
					return map;
				}
			}
		}
		System.err.println("输入有误");
		return null;
	}
}
