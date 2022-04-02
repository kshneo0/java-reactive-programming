package com.rp.sec02;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

	public static void main(String[] args) {
		
//		Flux<Integer> flux = Flux.just(1);
		
//		Flux<Integer> flux = Flux.just(1,2,3,4);
		
//      flux.subscribe( Util.onNext() );
		
//		Flux<Object> flux = Flux.empty();
//		
//        flux.subscribe(
//                Util.onNext(),
//                Util.onError(),
//                Util.onComplete());
        
		Flux<Object> flux = Flux.just(1,2, 3, "a", Util.faker().name().fullName());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
                
	}

}