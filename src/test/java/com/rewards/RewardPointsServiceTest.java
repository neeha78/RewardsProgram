package com.rewards;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rewards.dto.CustomerPointsDTO;
import com.rewards.dto.RewardPointsDTO;
import com.rewards.exceptions.RewardsException;
import com.rewards.model.RewardPoints;
import com.rewards.service.RewardsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RewardPointsServiceTest {

	@Autowired
	private RewardsService rewardsService;

	@Before
	public void before() throws Exception {
	}

	@Test
	public void getRewardPointsForCutomer1() {
		try {
			insertCustomer1Data();
			CustomerPointsDTO customerDetails = rewardsService.getRewardPoints("ABC");
			assertTrue(customerDetails.getTotalPoints() == 50);
			assertTrue(customerDetails.getRewards().size() == 2);
			List<RewardPointsDTO> rewards = customerDetails.getRewards();
			assertTrue(rewards.get(0).getMonth() == 3);
			assertTrue(rewards.get(0).getMonthPoints() == 50);
		} catch (RewardsException | ParseException p) {
			assertFalse(true);
		}
	}

	private void insertCustomer1Data() throws ParseException, RewardsException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		RewardPoints reward1 = new RewardPoints();
		reward1.setCustomerName("customer1");
		reward1.setCustomerId("ABC");
		reward1.setPurchaseAmount(100);
		reward1.setCreatedDate(sdf.parse("13/03/2023"));

		RewardPoints reward2 = new RewardPoints();
		reward2.setCustomerName("customer1");
		reward2.setCustomerId("ABC");
		reward2.setPurchaseAmount(40);
		reward2.setCreatedDate(sdf.parse("03/04/2023"));
		List<RewardPoints> list = new ArrayList<>();
		list.add(reward1);
		list.add(reward2);
		rewardsService.createTransactions(list);
	}

	@Test
	public void getRewardPointsForCutomer2() {
		try {
			insertCustomer2Data();
			CustomerPointsDTO customerDetails = rewardsService.getRewardPoints("XYZ");
			assertTrue(customerDetails.getTotalPoints() == 200);
			assertTrue(customerDetails.getRewards().size() == 2);
			List<RewardPointsDTO> rewards = customerDetails.getRewards();
			assertTrue(rewards.get(0).getMonth() == 3);
			assertTrue(rewards.get(0).getMonthPoints() == 90);
		} catch (RewardsException | ParseException e) {
			assertFalse(true);
		}
	}

	@Test
	public void getRewards() {
		try {
			List<CustomerPointsDTO> customerDetails = rewardsService.getRewardPoints();
			assertTrue(customerDetails.size() == 2);
		} catch (RewardsException p) {
			assertFalse(true);
		}
	}

	@Test
	public void getTransactions() {
		try {
			List<RewardPoints> customerDetails = (List<RewardPoints>) rewardsService.getTransactions();
			assertTrue(customerDetails.size() > 0);
		} catch (RewardsException p) {
			assertFalse(true);
		}
	}

	private void insertCustomer2Data() throws ParseException, RewardsException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// 2nd Customer
		RewardPoints c1 = new RewardPoints();
		c1.setCustomerName("customer2");
		c1.setPurchaseAmount(120);
		c1.setCustomerId("XYZ");
		c1.setCreatedDate(sdf.parse("11/03/2023"));

		RewardPoints c2 = new RewardPoints();
		c2.setCustomerName("customer2");
		c2.setPurchaseAmount(130);
		c2.setCustomerId("XYZ");
		c2.setCreatedDate(sdf.parse("03/04/2023"));

		List<RewardPoints> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);

		rewardsService.createTransactions(list);
	}
}
