package com.rp.sec03;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

	public static void main(String[] args) {
		
		Flux.generate(synchronousSink -> {
			String country = Util.faker().country().name();
			System.out.println("emitiing : "+ country);
			synchronousSink.next(country);
			if(country.toLowerCase().equals("canada")) {
				synchronousSink.complete();
			}
			
		})
		.subscribe(Util.subscriber());

	}

}
