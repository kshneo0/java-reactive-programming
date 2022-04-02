package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;

import reactor.core.publisher.Flux;

public class Lec08FluxPush {

	public static void main(String[] args) {
		
		NameProducer nameProducer = new NameProducer();
		
		//문제가 될수 있음. 항상 10개가 방출되지 않음.
		Flux.push(nameProducer)
			.subscribe(Util.subscriber());
		
		Runnable runnable = nameProducer::produce;
		
		for( int i=0; i<10; i++) {
			new Thread(runnable).start();
		}
		
		Util.sleepSeconds(2);


	}

}
