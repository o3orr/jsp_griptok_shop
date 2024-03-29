package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnAVO {
	private int qa_id;
	private String id;
	private int pid;
	private String question_title;
	private String question;
	private String answer;
	private String state;
	private Timestamp created_at;
}
