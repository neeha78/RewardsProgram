package com.rewards.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.common.RewardsUtil;
import com.rewards.exceptions.RewardsException;
import com.rewards.service.RewardsService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RewardsController {

	private Logger logger = LoggerFactory.getLogger(RewardsController.class);

	@Autowired
	private RewardsService rewardsService;

	@PostMapping("/transactions")
	public ResponseEntity<?> transactions() throws ParseException {
		logger.info("creating transactions");
		try {
			rewardsService.createTransactions(RewardsUtil.getDataSet());
			return new ResponseEntity<String>("Mockup Data is created", HttpStatus.CREATED);
		} catch (RewardsException e) {
			logger.error("Error in creating mockup data", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/transactions")
	public ResponseEntity<?> getTransactions() throws ParseException {
		logger.info("creating transactions");
		try {
			return new ResponseEntity<>(rewardsService.getTransactions(), HttpStatus.CREATED);
		} catch (RewardsException e) {
			logger.error("Error in creating mockup data", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getRewards")
	public ResponseEntity<?> getRewards() {
		logger.info("Get reward points ");
		try {
			return new ResponseEntity<>(rewardsService.getRewardPoints(), HttpStatus.OK);
		} catch (RewardsException e) {
			logger.error("Error while getting the reward points", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getRewards/{customerId}")
	public ResponseEntity<?> getRewards(@PathVariable("customerId") String customerId) {
		logger.info("Get reward points ");
		try {
			return new ResponseEntity<>(rewardsService.getRewardPoints(customerId), HttpStatus.OK);
		} catch (RewardsException e) {
			logger.error("Error while getting the reward points", e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
