package com.asus.springcloud.demoservice.service;

import com.asus.springcloud.demoservice.dto.DemoStudentDto;
import com.asus.springcloud.demoservice.param.DemoStudentSaveParam;
import com.asus.springcloud.demoservice.param.DemoStudentUpdateParam;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 事务层
 *
 * 所有逻辑实现都在 service 层。
 *
 * 原则上service层与entity 和 repository 不需要一一对应了，可以根据需求和业务逻辑自由组合，
 * 因为 service 层的设计，应该只由用户需求来决定，就是说用户需要什么功能，就在 service 层
 * 实现什么接口。多余的不需要，甚至不应该实现。
 *
 * service 层与 controller 层是对应的，因为 controller 层负责的就是将 service 层的接口
 * 开放出来。
 *
 * @author kevinli
 * @date 2018/9/3
 */
public interface DemoService {

    /* -------------------------------------------- jpa 基础实现 ------------------------------------------------------*/

    /**
     * 保存 student
     *
     * @param param DemoStudentSaveParam
     * @return DemoStudent
     */
    DemoStudentDto saveStudent(DemoStudentSaveParam param);

    /**
     * 更新 student
     *
     * @param param DemoStudentSaveParam
     * @return DemoStudent
     */
    DemoStudentDto updateStudent(DemoStudentUpdateParam param);

    /**
     * 用 id 删除 student
     *
     * @param id id
     * @return String
     */
    Object deleteStudent(Long id);

    /**
     * 根据 id 查询 student
     *
     * @param id id
     * @return DemoStudent
     */
    DemoStudentDto getStudentById(Long id);

    /**
     * 根据其他属性 查询 student，如 name
     *
     * @param name 名字
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByName(String name);

    /**
     * 查询名字等于 name 并且 年龄大于 age 的 student
     *
     * @param name 名字
     * @param age  年龄
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByNameAndAgeIsGreaterThan(String name, Integer age);

    /**
     * 查询所有 student
     *
     * @return List
     */
    List<DemoStudentDto> getStudents();

    /**
     * 查询所有 student，按照 age 排序
     *
     * @return List
     */
    List<DemoStudentDto> getStudentsOrderByAge();

    /**
     * 分页查询 student
     *
     * @param page 页数
     * @param size 条数
     * @return List
     */
    Page<DemoStudentDto> getStudentsByPage(int page, int size);


    /* ----------------------------------------------- sql 实现 ------------------------------------------------------*/

    /**
     * 根据其他属性 查询 student，如 name，原生 sql 实现
     *
     * @param name 名字
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByNameSql(String name);

    /**
     * 查询名字等于 name 并且 年龄大于 age 的 student，原生 sql 实现
     *
     * @param name 名字
     * @param age  年龄
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByNameAndAgeIsGreaterThanSql(String name, Integer age);


    /* ------------------------------------------ Specification 实现 -------------------------------------------------*/

    /**
     * 根据其他属性 查询 student，如 name，原生 Specification 实现
     *
     * @param name 名字
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByNameSpecification(String name);

    /**
     * 查询名字等于 name 并且 年龄大于 age 的 student，原生 Specification 实现
     *
     * @param name 名字
     * @param age  年龄
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByNameAndAgeIsGreaterThanSpecification(String name, Integer age);


    /* --------------------------------------------- Example 实现 ----------------------------------------------------*/

    /**
     * 根据其他属性 查询 student，如 name，原生 Example 实现
     *
     * @param name 名字
     * @return DemoStudent
     */
    List<DemoStudentDto> getStudentByNameExample(String name);
}
