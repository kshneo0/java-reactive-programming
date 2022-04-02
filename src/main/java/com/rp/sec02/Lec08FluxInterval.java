package com.rp.sec02;

import java.time.Duration;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec08FluxInterval {

	public static void main(String[] args) {
		
		Flux.interval(Duration.ofSeconds(1))
			.log()
			.subscribe(Util.onNext());
		
		Util.sleepSeconds(5);

	}

}
