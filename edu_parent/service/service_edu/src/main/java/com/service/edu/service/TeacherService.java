package com.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.service.edu.entity.vo.TeacherQueryVo;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author 
 * @since 2023-01-12
 */
public interface TeacherService extends IService<Teacher> {

    /**
     * 带查询条件的分页查询
     * @param pageParam         分页对象
     * @param teacherQueryVo    查询条件
     * @return
     */
    IPage<Teacher> selectPage(Page<Teacher> pageParam, TeacherQueryVo teacherQueryVo);

}
