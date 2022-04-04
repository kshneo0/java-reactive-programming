package com.rp.sec11;

import com.rp.courseutil.Util;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.One;

public class Lec01SinkOne {

    public static void main(String[] args) {

    	// mono 1 value / empty / error
        One<Object> sink = Sinks.one();
        
        Mono<Object> mono = sink.asMono();
        
        mono.subscribe(Util.subscriber("sam"));
        
        sink.tryEmitValue("hi");

    }

}