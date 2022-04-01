package com.rp.sec01;

import java.awt.event.ItemEvent;

import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

	public static void main(String[] args) {

		// publisher
		Mono<String>mono = Mono.just("ball");
		
		// 1
		// mono.subscribe();
		
		//2
		mono.subscribe(
			item -> System.out.println(item),
			err -> System.out.println(err.getMessage()),
			()-> System.out.println("Completed")			
		);
	}

}
