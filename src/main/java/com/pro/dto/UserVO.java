package com.pro.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserVO {
    private int num;
    private String id;
    private String username;
    private String email;
    private String pass;
    private Timestamp registration_date;
    private String is_admin;
    private String addr;
    private String addr2;
    private String phone;
   
}
