package com.multipolar.bootcamp.loggingaccount.repository;

import com.multipolar.bootcamp.loggingaccount.domain.AccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessLogRepository extends MongoRepository<AccessLog,String> {
}
