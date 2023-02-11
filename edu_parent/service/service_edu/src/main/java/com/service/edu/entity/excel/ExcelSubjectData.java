package com.service.edu.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName ExcelSubjectData
 * @Description 导入的课程分类的Excel标题
 * @Author hyj98
 * @Date 2023-02-09 21:46
 * @Version 1.0
 */
@Data
public class ExcelSubjectData {

    @ExcelProperty(value = "一级分类")
    private String levelOneTitle;

    @ExcelProperty(value = "二级分类")
    private String levelTwoTitle;

}
