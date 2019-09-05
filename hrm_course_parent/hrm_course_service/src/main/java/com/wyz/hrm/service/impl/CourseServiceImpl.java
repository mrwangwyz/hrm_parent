package com.wyz.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wyz.hrm.domain.Course;
import com.wyz.hrm.mapper.CourseMapper;
import com.wyz.hrm.query.CourseQuery;
import com.wyz.hrm.service.ICourseService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyz.hrm.util.PageList;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2019-09-04
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public PageList<Course> selectListPage(CourseQuery query) {
        Page<Course> page = new Page<>(query.getPage(), query.getRows());
        List<Course> courses=courseMapper.loadListPage(page,query);
        return new PageList<>(page.getTotal(), courses);
    }
}
