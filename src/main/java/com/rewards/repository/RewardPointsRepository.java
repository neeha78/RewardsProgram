package com.rewards.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rewards.model.RewardPoints;

@Repository
public interface RewardPointsRepository extends CrudRepository<RewardPoints, Long>{

	List<RewardPoints> findByCustomerId(String customerId);

	@Query("select distinct r.customerId from RewardPoints r")
	List<String> findDistinctByCustomerId();
} 
