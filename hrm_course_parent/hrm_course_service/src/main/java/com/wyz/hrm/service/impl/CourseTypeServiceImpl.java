package com.wyz.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wyz.hrm.domain.CourseType;
import com.wyz.hrm.mapper.CourseTypeMapper;
import com.wyz.hrm.query.CourseTypeQuery;
import com.wyz.hrm.service.ICourseTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wyz.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程目录 服务实现类
 * </p>
 *
 * @author wyz
 * @since 2019-09-01
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType> implements ICourseTypeService {

    @Autowired
    private CourseTypeMapper courseTypeMapper;
    @Override
    public PageList<CourseType> selectListPage(CourseTypeQuery query) {
        Page page=new Page(query.getPage(),query.getRows());
        System.out.println(query.getRows());
        List<CourseType> courseTypes=courseTypeMapper.loadListPage(page,query);
        System.out.println(page.getTotal()+"======================");
        return new PageList<>(page.getTotal(), courseTypes);
    }
}
