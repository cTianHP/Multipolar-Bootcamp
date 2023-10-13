package com.multipolar.bootcamp.loggingproduct.repository;

import com.multipolar.bootcamp.loggingproduct.domain.AccessLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccessLogRepository extends MongoRepository<AccessLog,String> {
}
