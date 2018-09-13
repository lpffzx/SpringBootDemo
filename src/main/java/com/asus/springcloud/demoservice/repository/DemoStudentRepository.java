package com.asus.springcloud.demoservice.repository;

import com.asus.springcloud.demoservice.entity.DemoStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 数据库交互层，原则上与 entity 一一对应，一张表一个Repository
 *
 * @author kevinli
 * @date 2018/9/3
 */
public interface DemoStudentRepository extends JpaRepository<DemoStudent, Long>, JpaSpecificationExecutor<DemoStudent> {

    List<DemoStudent> getByName(String name);

    List<DemoStudent> getByNameAndAgeIsGreaterThan(String name, Integer age);

    @Query(value = "SELECT ds FROM DemoStudent ds WHERE name = :name")
    List<DemoStudent> getByNameSql(@Param("name") String name);

    @Query(value = "SELECT * FROM demo_student WHERE name = ? AND age > ?", nativeQuery = true)
    List<DemoStudent> getByNameAndAgeIsGreaterThanSql(String name, Integer age);
}
