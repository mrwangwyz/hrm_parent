package com.wyz.hrm.service.impl;

import com.wyz.hrm.doc.EsCourse;
import com.wyz.hrm.query.EsCourseQuery;
import com.wyz.hrm.repository.EsRepository;
import com.wyz.hrm.service.IEsCourseService;
import com.wyz.hrm.util.PageList;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyz
 * @since 2019-09-05
 */
@Service
public class EsCourseServiceImpl implements IEsCourseService {
    @Autowired
    private EsRepository esRepository;
    @Override
    public void updateById(EsCourse esCourse) {
        esRepository.save(esCourse);
    }

    @Override
    public void insert(EsCourse esCourse) {
        esRepository.save(esCourse);
    }

    @Override
    public void deleteById(Long id) {
        esRepository.deleteById(id);
    }

    @Override
    public EsCourse selectById(Long id) {
        return esRepository.findById(id).get();
    }

    @Override
    public List<EsCourse> selectList(Object o) {
        Page<EsCourse> page=(Page)esRepository.findAll();
        return page.getContent();
    }

    @Override
    public PageList<EsCourse> selectListPage(EsCourseQuery query) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        BoolQueryBuilder bool = QueryBuilders.boolQuery();
        //模糊查询 @TODO
        bool.must(QueryBuilders.matchQuery("intro", "zhang"));
        //精确过滤 @TODO
        List<QueryBuilder> filters = bool.filter();
        filters.add(QueryBuilders.rangeQuery("age").gte(0).lte(200));

        builder.withQuery(bool); //query bool must(filter)
        //排序 @TODO
        builder.withSort(SortBuilders.fieldSort("age").order(SortOrder.ASC));

        //分页 当前页从0开始
        builder.withPageable(PageRequest.of(query.getPage()-1, query.getRows()));

        //构造查询条件
        NativeSearchQuery esQuery = builder.build();
        //查询
        Page<EsCourse> page = esRepository.search(esQuery);
        return new PageList<>(page.getTotalElements(),page.getContent());
    }
}
