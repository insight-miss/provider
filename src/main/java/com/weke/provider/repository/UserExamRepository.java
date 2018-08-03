package com.weke.provider.repository;

import com.weke.provider.mongodb.UserExamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserExamRepository extends MongoRepository<UserExamInfo,Integer> {

    UserExamInfo findByUserExamId(Integer userExamId);

}
