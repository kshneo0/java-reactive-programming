package com.rp.sec07;

import java.util.ArrayList;
import java.util.List;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02Drop {

	public static void main(String[] args) {
		
		// 75% 12
        System.setProperty("reactor.bufferSize.small", "16");
        
        List<Object> list = new ArrayList<>();
		
		Flux.create(fluxSink -> {
			for (int i = 0; i < 201; i++ ) {
				fluxSink.next(i);
				System.out.println("Pushed : " + i);
				Util.sleepMillis(1);
			}
			fluxSink.complete();
		})
//			.onBackpressureBuffer()
			.onBackpressureDrop(list::add)
			.publishOn(Schedulers.boundedElastic())
			.doOnNext( i-> {
				Util.sleepMillis(10);
			})
			.subscribe(Util.subscriber());
		
		Util.sleepSeconds(10);
		System.out.println(list);

	}

}
