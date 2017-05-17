package com.cn.hnust.model;

public class SystemContext {
	private static ThreadLocal<Integer> offset = new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> size = new ThreadLocal<Integer>();
	private static ThreadLocal<String> order = new ThreadLocal<String>();
	private static ThreadLocal<String> sort = new ThreadLocal<String>();
	
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		order.set(_order);
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		sort.set(_sort);
	}
	public static Integer getOffset() {
		return offset.get();
	}
	public static void setOffset(Integer _offset) {
		offset.set(_offset);
	}
	
	public static void removeOffset() {
		offset.remove();
	}
	
	public static Integer getSize() {
		return size.get();
	}
	public static void setSize(Integer _size) {
		size.set(_size);
	}
	
	public static void removeSize() {
		size.remove();
	}
	
	public static void removeOrder() {
		order.remove();
	}
	
	public static void removeSort() {
		sort.remove();
	}
}
