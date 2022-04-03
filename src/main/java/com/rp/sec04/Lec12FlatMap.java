package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

public class Lec12FlatMap {

	public static void main(String[] args) {
		
		UserService.getUsers()
			.flatMap(user -> OrderService.getOrders(user.getUserId()))	// mono / flux
//			.filter(p -> p > 10)
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
		
	}

}