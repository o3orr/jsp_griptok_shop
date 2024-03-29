package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
	public class CartVO {
		private int cart_id; 
		private String id; 
		private int pid; 
		private Timestamp createDate; // 주문일자
	}