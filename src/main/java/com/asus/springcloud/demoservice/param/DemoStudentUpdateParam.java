package com.asus.springcloud.demoservice.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kevinli
 * @date 2018/9/5
 */
@Data
@ApiModel(value = "更新DemoStudent参数实体")
public class DemoStudentUpdateParam {

    @ApiModelProperty(value = "id", required = true)
    private Long id;

    @ApiModelProperty(value = "年龄", required = true)
    private Integer age;

    @ApiModelProperty(value = "名字", required = true)
    private String name;
}
