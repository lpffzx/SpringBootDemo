package com.asus.springcloud.demoservice.repository;

import com.asus.springcloud.demoservice.entity.DemoClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kevinli
 * @date 2018/9/3
 */
public interface DemoClassRepository extends JpaRepository<DemoClass, Long> {
}
