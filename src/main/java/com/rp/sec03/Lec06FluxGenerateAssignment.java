package com.rp.sec03;

import java.util.concurrent.atomic.AtomicInteger;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

	public static void main(String[] args) {
		
		// canada
		// max = 10
		// subscriber cancels - exit
//		AtomicInteger automicInteger = new AtomicInteger(0);
		
		Flux.generate(synchronousSink -> {
			String country = Util.faker().country().name();
			System.out.println("emitiing : "+ country);
			synchronousSink.next(country);
//			automicInteger.incrementAndGet();
			if(country.toLowerCase().equals("canada")) {
				synchronousSink.complete();
			}
			
		})
		.subscribe(Util.subscriber());
		
//		automicInteger.incrementAndGet();	//여기서도 가능 

	}

}
