package com.rp.sec03.helper;

import java.util.function.Consumer;

import com.rp.courseutil.Util;

import reactor.core.publisher.FluxSink;

public class NameProducer implements Consumer<FluxSink<String>>{

	private FluxSink<String> fluxSink;
	
	@Override
	public void accept(FluxSink<String> t) {
		this.fluxSink = t;
		
	}
	
	public void produce() {
		String name = Util.faker().name().fullName();
		this.fluxSink.next(name);
	}

}
