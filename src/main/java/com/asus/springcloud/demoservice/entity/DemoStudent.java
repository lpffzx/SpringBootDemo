package com.asus.springcloud.demoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * @author kevinli
 * @date 2018/8/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo_student")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class DemoStudent extends DemoBaseEntity {

    @Column(name = "name", length = 16)
    private String name;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demo_class_id")
    private DemoClass demoClass;

    @JsonManagedReference
    @OneToMany(mappedBy = "demoStudent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DemoGrade> demoGrades;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "demo_student_demo_teacher"
            , joinColumns = {@JoinColumn(name = "demo_student_id")}
            , inverseJoinColumns = {@JoinColumn(name = "demo_teacher_id")})
    private List<DemoTeacher> demoTeachers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "demo_address_id")
    private DemoAddress demoAddress;

}
