package com.weke.provider.repository;

import com.weke.provider.mongodb.ProblemInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProblemInfoRepository extends MongoRepository<ProblemInfo,String> {

    public ProblemInfo findByUserId(String userId);
    public List<ProblemInfo> findAll();
}
