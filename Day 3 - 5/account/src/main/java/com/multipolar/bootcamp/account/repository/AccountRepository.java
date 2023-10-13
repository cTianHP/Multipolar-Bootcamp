package com.multipolar.bootcamp.account.repository;

import com.multipolar.bootcamp.account.domain.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account,String> {
    @Query("{ 'accountHolder.name' : { $regex: ?0, $options: 'i' } }")
    Optional<Account> findByNameCaseInsensitive(String name);
}
