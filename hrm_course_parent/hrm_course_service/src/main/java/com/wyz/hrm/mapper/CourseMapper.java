package com.wyz.hrm.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.wyz.hrm.domain.Course;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wyz.hrm.query.CourseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyz
 * @since 2019-09-04
 */
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> loadListPage(Page<Course> page, @Param("query") CourseQuery query);
}
