package com.wyz.hrm.service;

import com.wyz.hrm.domain.CourseType;
import com.baomidou.mybatisplus.service.IService;
import com.wyz.hrm.query.CourseTypeQuery;
import com.wyz.hrm.util.PageList;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author wyz
 * @since 2019-09-01
 */
public interface ICourseTypeService extends IService<CourseType> {

    PageList<CourseType> selectListPage(CourseTypeQuery query);
}
