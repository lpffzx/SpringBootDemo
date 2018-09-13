package com.asus.springcloud.demoservice.service.impl;

import com.asus.springcloud.demoservice.constant.Constants;
import com.asus.springcloud.demoservice.dto.DemoStudentDto;
import com.asus.springcloud.demoservice.entity.DemoStudent;
import com.asus.springcloud.demoservice.param.DemoStudentSaveParam;
import com.asus.springcloud.demoservice.param.DemoStudentUpdateParam;
import com.asus.springcloud.demoservice.repository.*;
import com.asus.springcloud.demoservice.service.DemoService;
import com.asus.springcloud.demoservice.util.ToDtoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author kevinli
 * @date 2018/9/3
 */
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoStudentRepository demoStudentRepository;

    @Autowired
    private DemoClassRepository demoClassRepository;

    @Autowired
    private DemoTeacherRepository demoTeacherRepository;

    @Autowired
    private DemoGradeRepository demoGradeRepository;

    @Autowired
    private DemoAddressRepository demoAddressRepository;

    /* -------------------------------------------- jpa 基础实现 ------------------------------------------------------*/

    @Override
    public DemoStudentDto saveStudent(DemoStudentSaveParam param) {
        DemoStudent student = new DemoStudent();
        student.setAge(param.getAge());
        student.setName(param.getName());
        return ToDtoUtils.toDto(demoStudentRepository.save(student));
    }

    @Override
    public DemoStudentDto updateStudent(DemoStudentUpdateParam param) {
        Long id = param.getId();
        Integer age = param.getAge();
        String name = param.getName();
        DemoStudent student = demoStudentRepository.getOne(id);
        if (age != null) {
            student.setAge(age);
        }
        if (!StringUtils.isEmpty(name)) {
            student.setName(name);
        }
        return ToDtoUtils.toDto(demoStudentRepository.save(student));
    }

    @Override
    public Object deleteStudent(Long id) {
        demoStudentRepository.deleteById(id);
        return Constants.OK;
    }

    @Override
    public DemoStudentDto getStudentById(Long id) {
        return ToDtoUtils.toDto(demoStudentRepository.getOne(id));
    }

    @Override
    public List<DemoStudentDto> getStudentByName(String name) {
        return ToDtoUtils.toDtoList(demoStudentRepository.getByName(name));
    }

    @Override
    public List<DemoStudentDto> getStudentByNameAndAgeIsGreaterThan(String name, Integer age) {
        return ToDtoUtils.toDtoList(demoStudentRepository.getByNameAndAgeIsGreaterThan(name, age));
    }

    @Override
    public List<DemoStudentDto> getStudents() {
        return ToDtoUtils.toDtoList(demoStudentRepository.findAll());
    }

    @Override
    public List<DemoStudentDto> getStudentsOrderByAge() {
        return ToDtoUtils.toDtoList(demoStudentRepository.findAll(Sort.by(Sort.Direction.ASC, "age")));
    }

    @Override
    public Page<DemoStudentDto> getStudentsByPage(int page, int size) {
        return demoStudentRepository.findAll(PageRequest.of(page - 1, size)).map(p -> ToDtoUtils.toDto(p));
    }


    /* ----------------------------------------------- sql 实现 ------------------------------------------------------*/

    @Override
    public List<DemoStudentDto> getStudentByNameSql(String name) {
        return ToDtoUtils.toDtoList(demoStudentRepository.getByNameSql(name));
    }

    @Override
    public List<DemoStudentDto> getStudentByNameAndAgeIsGreaterThanSql(String name, Integer age) {
        return ToDtoUtils.toDtoList(demoStudentRepository.getByNameAndAgeIsGreaterThanSql(name, age));
    }


    /* ------------------------------------------ Specification 实现 -------------------------------------------------*/

    @Override
    public List<DemoStudentDto> getStudentByNameSpecification(String name) {
        return ToDtoUtils.toDtoList(demoStudentRepository.findAll((Specification<DemoStudent>) (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.isEmpty(name)) {
                criteriaQuery
                        .where(criteriaBuilder
                                .equal(root.get("name").as(String.class), name));
            }
            return null;
        }));
    }

    @Override
    public List<DemoStudentDto> getStudentByNameAndAgeIsGreaterThanSpecification(String name, Integer age) {
        return ToDtoUtils.toDtoList(demoStudentRepository.findAll((Specification<DemoStudent>) (root, criteriaQuery, criteriaBuilder) -> {
            if (!StringUtils.isEmpty(name) && age != null) {
                criteriaQuery
                        .where(criteriaBuilder
                                .and(criteriaBuilder.equal(root.get("name").as(String.class), name)
                                        , criteriaBuilder.gt(root.get("age").as(Integer.class), age)));
            }
            return null;
        }));
    }


    /* --------------------------------------------- Example 实现 ----------------------------------------------------*/

    @Override
    public List<DemoStudentDto> getStudentByNameExample(String name) {
        DemoStudent demoStudent = new DemoStudent();
        demoStudent.setName(name);
        // 因为 createTime 有初始值，这里避免干扰，设为null，否则会当做查询条件
        demoStudent.setCreateTime(null);
        Example<DemoStudent> example = Example.of(demoStudent);
        return ToDtoUtils.toDtoList(demoStudentRepository.findAll(example));
    }
}
