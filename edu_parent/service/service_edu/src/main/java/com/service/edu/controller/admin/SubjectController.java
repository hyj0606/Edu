package com.service.edu.controller.admin;


import com.service.base.result.R;
import com.service.base.result.ResultCodeEnum;
import com.service.edu.entity.Subject;
import com.service.edu.service.SubjectService;
import com.servicebase.exception.JavaException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author 
 * @since 2023-02-09
 */
@RestController
@RequestMapping("/admin/edu/subject")
@CrossOrigin
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @ApiOperation("excel批量导入课程分类")
    @PostMapping("/import")
    public R batchImport(@ApiParam(value = "Excel文件", required = true) @RequestParam("file")MultipartFile file ){
        try {
            InputStream inputStream = file.getInputStream();
            subjectService.batchImport(inputStream);
            return R.ok().message("批量导入成功");
        } catch (IOException e) {
            throw new JavaException(ResultCodeEnum.EXCEL_DATA_IMPORT_ERROR);
        }
    }

}

