package com.rp.sec01;

import java.awt.event.ItemEvent;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

	public static void main(String[] args) {

		// publisher
//		Mono<String>mono = Mono.just("ball");
		
		Mono<Integer>mono = Mono.just("ball")
				   .map(String::length)
//				   .map(l -> l/1);
				   .map(l -> l/0);
		
		// 1
		// mono.subscribe();
		
		//2
		mono.subscribe(
			Util.onNext(),
			Util.onError(),
			Util.onComplete()		
		);
	}

}
