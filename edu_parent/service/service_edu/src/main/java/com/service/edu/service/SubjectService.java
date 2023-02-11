package com.service.edu.service;

import com.service.edu.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author 
 * @since 2023-02-09
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 批量导入
     * @param inputStream
     */
    void batchImport(InputStream inputStream);

}
