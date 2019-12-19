package com.dukoia.microservice.monitor.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Dukoia
 * @createTime 2019/12/11 9:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private String grade;
    private Integer sex;

}
