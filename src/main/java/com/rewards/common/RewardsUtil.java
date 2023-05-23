package com.rewards.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.rewards.model.RewardPoints;

public class RewardsUtil {
	
	public static List<RewardPoints> getDataSet() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		// 1st Customer
		RewardPoints reward1 = new RewardPoints();
		reward1.setCustomerName("customer1");
		reward1.setCustomerId("ABC");
		reward1.setPurchaseAmount(100);
		reward1.setCreatedDate(sdf.parse("13/03/2023"));
		
		RewardPoints reward2 = new RewardPoints();
		reward2.setCustomerName("customer1");
		reward2.setCustomerId("ABC");
		reward2.setPurchaseAmount(40);
		reward2.setCreatedDate(sdf.parse("01/04/2023"));
		
		RewardPoints reward3 = new RewardPoints();
		reward3.setCustomerName("customer1");
		reward3.setCustomerId("ABC");
		reward3.setPurchaseAmount(140);
		reward3.setCreatedDate(sdf.parse("02/04/2023"));
		
		// 2nd Customer
		RewardPoints c1 = new RewardPoints();
		c1.setCustomerName("customer2");
		c1.setCustomerId("XYZ");
		c1.setPurchaseAmount(120);
		c1.setCreatedDate(sdf.parse("11/03/2023"));
		
		RewardPoints c2 = new RewardPoints();
		c2.setCustomerName("customer2");
		c2.setCustomerId("XYZ");
		c2.setPurchaseAmount(130);
		c2.setCreatedDate(sdf.parse("01/04/2023"));
		
		
		List<RewardPoints> list = new ArrayList<>();
		list.add(reward1);
		list.add(reward2);
		list.add(reward3);
		list.add(c1);
		list.add(c2);
		
		return list;
	}

}
