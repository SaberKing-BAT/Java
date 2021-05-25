package com.lyc.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//全参构造器
@NoArgsConstructor//空参
public class Payment {

  private long id;
  private String serial;

}
