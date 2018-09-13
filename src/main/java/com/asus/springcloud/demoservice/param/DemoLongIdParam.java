package com.asus.springcloud.demoservice.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author kevinli
 * @date 2018/9/5
 */
@Data
@ApiModel(value = "Long型id参数实体")
public class DemoLongIdParam {

    @ApiModelProperty(value = "id", required = true)
    private Long id;
}
