package com.weke.provider.repository;

import com.weke.provider.mongodb.TestInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestInfoRepository extends MongoRepository<TestInfo,Integer> {

    List<TestInfo> findAllBy();

    TestInfo findByTestId(Integer testId);
}
