package com.rp.sec04;

import java.time.Duration;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec05Delay {

	public static void main(String[] args) {
		
		System.setProperty("reactor.bufferSize.x","9");
		
		Flux.range(1,100)	//32개가 default
			.log()
			.delayElements(Duration.ofSeconds(1))
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);

	}

}
