package com.service.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.service.edu.entity.Subject;
import com.service.edu.entity.excel.ExcelSubjectData;
import com.service.edu.mapper.SubjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http11.Constants;

import static org.apache.coyote.http11.Constants.a;

/**
 * @ClassName ExcelSubjectDataListener
 * @Description 读取上传的excel
 * @Author hyj98
 * @Date 2023-02-09 21:48
 * @Version 1.0
 */
@Slf4j
public class ExcelSubjectDataListener extends AnalysisEventListener<ExcelSubjectData> {

    // 不能使用@Autowire注入，因为这个类没有被spring托管
    private SubjectMapper subjectMapper;

    public ExcelSubjectDataListener(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    /**
     * 遍历每一行数据
     * @param excelSubjectData      每一行数据
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelSubjectData excelSubjectData, AnalysisContext analysisContext) {

        // 一级标题
        String levelOneTitle = excelSubjectData.getLevelOneTitle();
        // 二级标题
        String levelTwoTitle = excelSubjectData.getLevelTwoTitle();
        // 组装数据
        // 判断以及标题是否存在
        Subject subjectLevelOne = getByTitle(levelOneTitle);
        String parentId = null;
        if (subjectLevelOne == null) {          // 不存在，新增
            // 组装一级类别
            Subject subject = new Subject();
            subject.setParentId("0");
            subject.setTitle(levelOneTitle);
            // 存入数据库
            subjectMapper.insert(subject);
            parentId = subject.getId();
        }else {
            parentId = subjectLevelOne.getId();
        }

        // 将第二级类别存入数据库，也要防止数据重复
        Subject subByTitleLevelTwo = getSubByTitle(levelTwoTitle,parentId);
        if (subByTitleLevelTwo == null) {
            // 组装二级类别
            Subject subject = new Subject();
            subject.setParentId(parentId);
            subject.setTitle(levelTwoTitle);
            // 存入数据库
            subjectMapper.insert(subject);
        }

    }

    /**
     * 所有数据读取之后的收尾工作
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        log.info("全部记录解析完成");

    }


    /**
     * 根据一级分类的名称查询数据是否存在
     * @param title
     * @return
     */
    private Subject getByTitle(String title){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",title);
        queryWrapper.eq("parent_id","0");
        return subjectMapper.selectOne(queryWrapper);
    }

    /**
     * 根据二级分类的名称查询数据是否存在
     * @param title
     * @return
     */
    private Subject getSubByTitle(String title, String parentId){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",title);
        queryWrapper.eq("parent_id",parentId);
        return subjectMapper.selectOne(queryWrapper);
    }

}
