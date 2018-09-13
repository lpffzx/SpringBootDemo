package com.asus.springcloud.demoservice.controller;

import com.asus.springcloud.demoservice.common.CommonResult;
import com.asus.springcloud.demoservice.param.DemoLongIdParam;
import com.asus.springcloud.demoservice.param.DemoStudentSaveParam;
import com.asus.springcloud.demoservice.param.DemoStudentUpdateParam;
import com.asus.springcloud.demoservice.service.DemoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author kevinli
 * @date 2018/9/3
 */
@Api(value = "Demo Controller", tags = {"Demo 接口"})
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ApiOperation(value = "保存Student", notes = "用户获取exp得失记录")
    @RequestMapping(value = "student/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult saveStudent(@RequestBody @ApiParam(name = "param", value = "保存DemoStudent参数实体", required = true) DemoStudentSaveParam param) {
        return CommonResult.success(demoService.saveStudent(param));
    }

    @ApiOperation(value = "更新Student", notes = "用户获取exp得失记录")
    @RequestMapping(value = "student/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult updateStudent(@RequestBody @ApiParam(name = "param", value = "更新DemoStudent参数实体", required = true) DemoStudentUpdateParam param) {
        return CommonResult.success(demoService.updateStudent(param));
    }

    @ApiOperation(value = "删除Student", notes = "用户获取exp得失记录")
    @RequestMapping(value = "student/delete/id", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult deleteStudent(@RequestBody @ApiParam(name = "param", value = "Long型id参数实体", required = true) DemoLongIdParam param) {
        Long id = param.getId();
        return CommonResult.success(demoService.deleteStudent(id));
    }

    @ApiOperation(value = "根据id查询Student", notes = "传入参数id，根据id查找Student数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true)
    })
    @RequestMapping(value = "student/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult getStudentById(@RequestParam(name = "id") Long id) {
        return CommonResult.success(demoService.getStudentById(id));
    }

    @ApiOperation(value = "查询所有Student", notes = "查询所有Student数据")
    @RequestMapping(value = "student/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult getStudents() {
        return CommonResult.success(demoService.getStudents());
    }

    @ApiOperation(value = "查询所有Student按照age排序", notes = "按照年龄排序，查询所有student数据")
    @RequestMapping(value = "student/orderByAge", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult getStudentsOrderByAge() {
        return CommonResult.success(demoService.getStudentsOrderByAge());
    }

    @ApiOperation(value = "分页查询Student", notes = "传入参数页数和条数，分页查询所有student数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "条数", defaultValue = "10")
    })
    @RequestMapping(value = "student/page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult getStudentsByPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page, @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return CommonResult.success(demoService.getStudentsByPage(page, size));
    }

    @ApiOperation(value = "根据name查询tudent", notes = "传入参数name，根据name查询对应student数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true)
    })
    @RequestMapping(value = "student/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult getStudentsByName(@RequestParam(name = "name") String name) {
        // jpa 实现
//        return CommonResult.success(demoService.getStudentByName(name));
        // sql 实现
//        return CommonResult.success(demoService.getStudentByNameSql(name));
        // Specification
//        return CommonResult.success(demoService.getStudentByNameSpecification(name));
        // Example
        return CommonResult.success(demoService.getStudentByNameExample(name));
    }

    @ApiOperation(value = "根据name和age查询Student", notes = "传入参数name和age，查询name匹配且age大于传入参数值得student数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名字", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", required = true)
    })
    @RequestMapping(value = "student/name/age", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommonResult getStudentsByNameAndAgeIsGreaterThan(@RequestParam(name = "name") String name, @RequestParam(name = "age") Integer age) {
        // jpa 实现
//        return CommonResult.success(demoService.getStudentByNameAndAgeIsGreaterThan(name, age));
        // sql 实现
//        return CommonResult.success(demoService.getStudentByNameAndAgeIsGreaterThanSql(name, age));
        // Specification
        return CommonResult.success(demoService.getStudentByNameAndAgeIsGreaterThanSpecification(name, age));
    }
}
