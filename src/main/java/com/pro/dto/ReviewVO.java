package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
		private int review_id;
		private String id;
		private int pid;
		private int rating;
		private String content;
		private String img;
		private Timestamp registration_date;
		
}
