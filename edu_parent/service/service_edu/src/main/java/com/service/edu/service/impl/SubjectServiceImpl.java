package com.service.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.service.edu.entity.Subject;
import com.service.edu.entity.excel.ExcelSubjectData;
import com.service.edu.listener.ExcelSubjectDataListener;
import com.service.edu.mapper.SubjectMapper;
import com.service.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author 
 * @since 2023-02-09
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;

    /**
     * 批量导入
     *
     * @param inputStream
     */
    @Override
    public void batchImport(InputStream inputStream) {
        EasyExcel.read(inputStream, ExcelSubjectData.class, new ExcelSubjectDataListener(subjectMapper)).excelType(ExcelTypeEnum.XLS).sheet().doRead();
    }
}
