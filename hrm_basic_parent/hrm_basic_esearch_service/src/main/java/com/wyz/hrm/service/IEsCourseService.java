package com.wyz.hrm.service;

import com.wyz.hrm.doc.EsCourse;
import com.wyz.hrm.query.EsCourseQuery;
import com.wyz.hrm.util.PageList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyz
 * @since 2019-09-05
 */
public interface IEsCourseService{

    void updateById(EsCourse esCourse);

    void insert(EsCourse esCourse);

    void deleteById(Long id);

    EsCourse selectById(Long id);

    List<EsCourse> selectList(Object o);

    PageList<EsCourse> selectListPage(EsCourseQuery query);
}
