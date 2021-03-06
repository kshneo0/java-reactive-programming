package com.rp.sec11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

public class Lec04SinkMulti {

    public static void main(String[] args) {

        // handle through which we would push items
//        Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();
    	Many<Object> sink = Sinks.many().multicast().directAllOrNothing();

        // handle through which subscribers will receive items
        Flux<Object> flux = sink.asFlux();
 
        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("jake"));

        sink.tryEmitNext("new msg");
    }
}
