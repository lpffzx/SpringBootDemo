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
@Table(name = "demo_class")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class DemoClass extends DemoBaseEntity {

    @Column(name = "name", length = 8, nullable = false)
    private String name;

}
