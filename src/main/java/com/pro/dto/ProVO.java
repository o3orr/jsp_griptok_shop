package com.pro.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProVO {
	private int pid;
	private String pname;
	private String content;
	private int price;
	private Integer stock;
	private Integer category_id;
	private String img;
	
}
