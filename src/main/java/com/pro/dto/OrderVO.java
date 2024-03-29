package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	private int orderid; 
	private String Id; // 구매자 아이디
	private String userName; // 구매자 이름
	private int pid; // 구매 상품
	private Timestamp orderDate; // 주문일자
	private int price; // 구매 상품 가격

}