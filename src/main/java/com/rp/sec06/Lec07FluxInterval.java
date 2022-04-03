package com.rp.sec06;

import java.time.Duration;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec07FluxInterval {

	public static void main(String[] args) {
		
		Flux.interval(Duration.ofSeconds(1))
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);

	}

}
