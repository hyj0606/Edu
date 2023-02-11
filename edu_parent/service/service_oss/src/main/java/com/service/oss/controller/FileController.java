package com.service.oss.controller;

import com.service.base.result.R;
import com.service.base.result.ResultCodeEnum;
import com.service.base.utils.ExceptionUtils;
import com.service.oss.service.FileService;
import com.servicebase.exception.JavaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName FileController
 * @Description 阿里云文件管理控制类
 * @Author hyj98
 * @Date 2023-02-07 21:30
 * @Version 1.0
 */
@Api(description = "阿里云文件管理")
@RestController
@RequestMapping("admin/oss/file")
@Slf4j
@CrossOrigin
public class FileController {

    @Resource
    private FileService fileService;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public R upload(@ApiParam(value = "文件", required = true) @RequestParam("file") MultipartFile file,
                    @ApiParam(value = "模块", required = true) @RequestParam("module") String module){
        try {
            InputStream inputStream = file.getInputStream();
            String originalFileName = file.getOriginalFilename();

            String url = fileService.upload(inputStream, module, originalFileName);
            return R.ok().message("文件上传成功").data("url",url);

        } catch (IOException e) {
            log.error(ExceptionUtils.getMessage(e));
            throw new JavaException(ResultCodeEnum.FILE_UPLOAD_ERROR);
        }
    }

}
