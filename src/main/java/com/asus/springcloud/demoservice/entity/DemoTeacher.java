package com.asus.springcloud.demoservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * @author kevinli
 * @date 2018/9/3
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "demo_teacher")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class DemoTeacher extends DemoBaseEntity {

    @Column(name = "name", length = 8, nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "course", length = 8, nullable = false)
    private String course;

    @JsonIgnore
    @ManyToMany(mappedBy = "demoTeachers", fetch = FetchType.LAZY)
    private List<DemoStudent> demoStudents;
}
