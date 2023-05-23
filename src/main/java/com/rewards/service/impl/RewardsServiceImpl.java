package com.rewards.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.dto.CustomerPointsDTO;
import com.rewards.dto.RewardPointsDTO;
import com.rewards.exceptions.RewardsException;
import com.rewards.model.RewardPoints;
import com.rewards.repository.RewardPointsRepository;
import com.rewards.service.RewardsService;

@Service
public class RewardsServiceImpl implements RewardsService {

	private Logger logger = LoggerFactory.getLogger(RewardsServiceImpl.class);

	@Autowired
	private RewardPointsRepository repositoy;

	@Override
	public void createTransactions(List<RewardPoints> list) throws RewardsException {
		try {
			for (RewardPoints r : list) {
				Integer points = getPoints(r);
				r.setPoints(points);
				repositoy.save(r);
			}
		} catch (Exception e) {
			logger.error("Error while creating mockup data", e);
			throw new RewardsException("Unable to mockup the data:" + e.getMessage());
		}
	}

	@Override
	public Iterable<RewardPoints> getTransactions() throws RewardsException {
		return repositoy.findAll();
	}

	@Override
	public List<CustomerPointsDTO> getRewardPoints() throws RewardsException {
		logger.info("Calculating Reward points for all customers");
		try {
			List<CustomerPointsDTO> details = new ArrayList<CustomerPointsDTO>();
			List<String> customerIds = repositoy.findDistinctByCustomerId();
			for (String id : customerIds) {
				List<RewardPoints> customerTransactions = repositoy.findByCustomerId(id);
				details.add(getRewardPoints(customerTransactions,id));
			}
			return details;
		} catch (Exception e) {
			logger.error("Error while calculating Reward points for all customers", e);
			throw new RewardsException("Unable to Reward points for all customers :" + e.getMessage());
		}
	}

	private CustomerPointsDTO getRewardPoints(List<RewardPoints> customerTransactions, String customerId) {
		if(customerTransactions.size()==0)return new CustomerPointsDTO();
		Map<Object, Long> months = customerTransactions.stream()
				.collect(Collectors.groupingBy(element -> element.getCreatedDate().getMonth(),
						Collectors.summingLong(element -> element.getPoints())));

		List<RewardPointsDTO> rewardsDTO = new ArrayList<RewardPointsDTO>();
		Long total = 0l;
		for (Entry<Object, Long> entry : months.entrySet()) {
			RewardPointsDTO dto = new RewardPointsDTO();
			dto.setMonth(((Integer) entry.getKey() + 1));
			Long monthTotal = entry.getValue();
			total += monthTotal;
			dto.setMonthPoints(monthTotal);

			rewardsDTO.add(dto);
		}

		CustomerPointsDTO customerDetails = new CustomerPointsDTO();
		customerDetails.setTotalPoints(total);
		customerDetails.setRewards(rewardsDTO);
		customerDetails.setCustomerId(customerId);
		
		return customerDetails;
	}

	@Override
	public CustomerPointsDTO getRewardPoints(String customerId) throws RewardsException {
		logger.info("Calculating customer reward points");
		try {
			return getRewardPoints(repositoy.findByCustomerId(customerId),customerId);
		} catch (Exception e) {
			logger.error("Error while calculating customer reward points", e);
			throw new RewardsException("Unable to caluclate the reward points :" + e.getMessage());
		}
	}

	private Integer getPoints(RewardPoints r) {
		Integer amount = r.getPurchaseAmount();
		if (amount <= 50) {
			return 0;
		} else if (amount <= 100) {
			return (amount - 50) * 1;
		} else {
			return 50 + (amount % 100) * 2;
		}
	}

}
