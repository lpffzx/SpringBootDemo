package com.asus.springcloud.demoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author kevinli
 * @date 2018/9/3
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo_address")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class DemoAddress extends DemoBaseEntity {

    @Column(name = "country", length = 16, nullable = false)
    private String country;

    @Column(name = "province", length = 16, nullable = false)
    private String province;

    @Column(name = "city", length = 16, nullable = false)
    private String city;

    @Column(name = "detail")
    private String detail;
}
