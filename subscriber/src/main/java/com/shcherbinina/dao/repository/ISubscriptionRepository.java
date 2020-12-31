package com.shcherbinina.dao.repository;

import com.shcherbinina.dao.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ISubscriptionRepository extends CrudRepository<Subscription, BigInteger> {
}
