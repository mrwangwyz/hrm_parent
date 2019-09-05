package com.wyz.hrm.service;

import com.wyz.hrm.domain.Course;
import com.baomidou.mybatisplus.service.IService;
import com.wyz.hrm.query.CourseQuery;
import com.wyz.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyz
 * @since 2019-09-04
 */
public interface ICourseService extends IService<Course> {

    PageList<Course> selectListPage(CourseQuery query);
}
