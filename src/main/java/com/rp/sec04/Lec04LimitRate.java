package com.rp.sec04;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec04LimitRate {

	public static void main(String[] args) {
		
		Flux.range(1,1000)
			.log()
//			.limitRate(100, 99)	//Default 75, 여기서는 99개씩 가져오도록 요청
			.limitRate(100, 0)	//100개 가져오고 난 다음에 요청 
			.subscribe(Util.subscriber());

	}

}
