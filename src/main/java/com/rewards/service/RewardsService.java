package com.rewards.service;

import java.util.List;

import com.rewards.dto.CustomerPointsDTO;
import com.rewards.exceptions.RewardsException;
import com.rewards.model.RewardPoints;

public interface RewardsService {

	void createTransactions(List<RewardPoints> list)throws RewardsException;
	
	Iterable<RewardPoints> getTransactions()throws RewardsException;
	
	CustomerPointsDTO getRewardPoints(String customerId)throws RewardsException;
	
	List<CustomerPointsDTO> getRewardPoints()throws RewardsException;
}
