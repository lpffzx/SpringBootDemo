package com.asus.springcloud.demoservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author kevinli
 * @date 2018/9/3
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo_grade")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class DemoGrade extends DemoBaseEntity {

    @Column(name = "course", length = 8, nullable = false)
    private String course;

    @Column(name = "mark", nullable = false)
    private BigDecimal mark = BigDecimal.ZERO;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "demo_student_id")
    private DemoStudent demoStudent;
}
