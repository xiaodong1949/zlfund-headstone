package com.zlfund.headstone.core.mongo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.common.dao.BaseMongoRepository;
import com.zlfund.headstone.core.mongo.documents.CustinfoDocument;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月28日
 */
@Repository("custInfoRepository")
public class CustInfoRepository implements BaseMongoRepository<CustinfoDocument> {
    @Autowired
    MongoTemplate fundMongoTemplate;

    /** 
     * 根据指定条件查询数据条数
     * @param query
     * @return
     * @return 
     * @create: 2017年2月28日
     * @author: Yang Xiaodong
     * @history: 
     */
    public long count(Query query) {
        return fundMongoTemplate.count(query, CustinfoDocument.class);
    }
}
