package com.rp.sec03;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

	public static void main(String[] args) {
		
		// only one instance of fluxsink
		Flux.create(fluxSink -> {

			String country;
			int count = 0;
			do {
				country = Util.faker().country().name();
				System.out.println("emitting : " + country + " cnt : "+ count);
				fluxSink.next(country);
				count ++;
			} while(!country.toLowerCase().equals("canada") && 
					!fluxSink.isCancelled() &&
					count < 10);
					
			fluxSink.complete();
					
		})
//		.take(3)
		.subscribe(Util.subscriber());

	}

}
