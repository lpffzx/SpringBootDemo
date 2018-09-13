package com.asus.springcloud.demoservice.util;

import com.asus.springcloud.demoservice.dto.DemoStudentDto;
import com.asus.springcloud.demoservice.entity.DemoStudent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevinli
 * @date 2018/9/5
 */
public class ToDtoUtils {

    public static DemoStudentDto toDto(DemoStudent student) {
        DemoStudentDto dto = new DemoStudentDto();
        dto.setAge(student.getAge());
        dto.setName(student.getName());
        return dto;
    }

    public static List<DemoStudentDto> toDtoList(List<DemoStudent> list) {
        List<DemoStudentDto> dtoList = new ArrayList<>();
        for (DemoStudent student : list) {
            dtoList.add(toDto(student));
        }
        return dtoList;
    }
}
