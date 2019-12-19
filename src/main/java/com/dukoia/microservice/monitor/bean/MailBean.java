package com.dukoia.microservice.monitor.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Dukoia
 * @createTime 2019/12/19 10:41
 */
@Data
public class MailBean implements Serializable {

    private String recipient;
    private String subject;
    private String content;
}
