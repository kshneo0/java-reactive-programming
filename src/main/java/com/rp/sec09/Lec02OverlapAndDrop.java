package com.rp.sec09;

import java.time.Duration;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec02OverlapAndDrop {

	public static void main(String[] args) {
		
        eventStream()
        .buffer(3, 5)
        .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

	}
	
    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event"+i);
    }

}
