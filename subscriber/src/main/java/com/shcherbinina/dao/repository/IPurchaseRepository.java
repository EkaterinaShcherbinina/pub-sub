package com.shcherbinina.dao.repository;

import com.shcherbinina.dao.entity.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface IPurchaseRepository extends CrudRepository<Purchase, BigInteger> {
}
