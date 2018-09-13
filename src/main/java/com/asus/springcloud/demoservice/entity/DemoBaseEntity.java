package com.asus.springcloud.demoservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author kevinli
 * @date 2018/9/3
 */
@Data
@MappedSuperclass
public class DemoBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    @Column(name = "create_time", length = 19, updatable = false)
    private Date createTime = new Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    @Column(name = "update_time", length = 19, columnDefinition = "TIMESTAMP")
    private Date updateTime;
}
