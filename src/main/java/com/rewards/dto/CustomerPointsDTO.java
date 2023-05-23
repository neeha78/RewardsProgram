package com.rewards.dto;

import java.util.List;

public class CustomerPointsDTO {
	private String customerId;
	private Long totalPoints;
	private List<RewardPointsDTO> rewards;
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Long getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Long totalPoints) {
		this.totalPoints = totalPoints;
	}
	public List<RewardPointsDTO> getRewards() {
		return rewards;
	}
	public void setRewards(List<RewardPointsDTO> rewards) {
		this.rewards = rewards;
	}
	
	

}
