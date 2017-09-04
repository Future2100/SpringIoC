package com.netease.nos.controller;

import com.netease.nos.ddbdao.BucketInfoMapper;
import com.netease.nos.limitinfodao.GetQuestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BucketNameController {
    @Autowired
    @Qualifier("ddbSqlSessionFactory")
    SqlSessionFactory ddbSqlSessionFactory;

    @Autowired
    @Qualifier("limitInfoSqlSessionFactory")
    SqlSessionFactory limitInfoSqlSessionFactory;

    @Autowired
    BucketInfoMapper bucketInfoMapper;

    @Autowired
    GetQuestMapper getQuestMapper;


    @GetMapping("/bucketName/{productId}")
    public String getBucketName(@PathVariable("productId") String productId){
        SqlSession sqlSession = ddbSqlSessionFactory.openSession();
        BucketInfoMapper bucketInfoMapper = sqlSession.getMapper(BucketInfoMapper.class);
        String bucketName =  bucketInfoMapper.getBucketName(productId);

        System.out.println(bucketName);


        System.out.println(limitInfoSqlSessionFactory.openSession().getMapper(GetQuestMapper.class).getGetQuest("230-u0061-u0073-u006c"));

        return bucketInfoMapper.getBucketName(productId) + " : " + getQuestMapper.getGetQuest("230-u0061-u0073-u006c");
    }
}
