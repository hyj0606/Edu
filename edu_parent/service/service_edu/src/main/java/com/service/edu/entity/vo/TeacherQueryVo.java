package com.service.edu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName TeacherQueryVo
 * @Description 讲师 查询对象
 * @Author hyj98
 * @Date 2023-01-12 16:21
 * @Version 1.0
 */
@ApiModel("讲师 查询对象")
@Data
public class TeacherQueryVo {

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师级别", example = "1")
    private Integer level;

    @ApiModelProperty(value = "入驻开始时间")
    private String joinDateBegin;

    @ApiModelProperty(value = "入驻结束时间")
    private String joinDateEnd;

}
