package com.rp.sec06;

import java.util.ArrayList;
import java.util.List;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {

	public static void main(String[] args) {
		
//		List<Integer> list = new ArrayList<>();
		
		
		Flux.range(1,10)
			.parallel(10)
			.runOn(Schedulers.boundedElastic())
			.doOnNext(i -> printThreadName("next " + i))
			.sequential()
			.subscribe(v -> printThreadName("sub "+ v));
//			.subscribe(v -> list.add(v));
		
		Util.sleepSeconds(5);
		
//		System.out.println(list.size());

	}

    private static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }

}
