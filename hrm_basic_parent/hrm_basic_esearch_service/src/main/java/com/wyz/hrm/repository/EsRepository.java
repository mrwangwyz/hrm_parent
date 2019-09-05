package com.wyz.hrm.repository;

import com.wyz.hrm.doc.EsCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsRepository extends ElasticsearchRepository<EsCourse,Long> {
}
