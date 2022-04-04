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
        
//        sink.tryEmitValue("hi");
//        sink.tryEmitEmpty();
//        sink.tryEmitError(new RuntimeException("err"));
        sink.emitValue("hi", (signglType, emitResult) -> {
        	System.out.println(signglType.name());
        	System.out.println(emitResult.name());
        	return false;
        });
        
        sink.emitValue("hello", (signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;	//true일 경우 반복해서 시도 
        });
        

    }

}