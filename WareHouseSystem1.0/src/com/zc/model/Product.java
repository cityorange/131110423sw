package com.zc.model;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pid;
	private String productName;
	private Double price;
	private Integer num;
	private Double totalPrice;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(String pid, String productName, Double price, Integer num,
			Double totalPrice) {
		this.pid = pid;
		this.productName = productName;
		this.price = price;
		this.num = num;
		this.totalPrice = totalPrice;
	}

	// Property accessors

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}