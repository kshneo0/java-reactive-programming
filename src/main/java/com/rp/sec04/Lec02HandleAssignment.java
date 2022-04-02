package com.rp.sec04;

import com.rp.courseutil.Util;

import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

	public static void main(String[] args) {
		
		Flux.generate(syncSink -> syncSink.next(Util.faker().country().name()))
			.map(Object::toString)
			.handle((s, syncSink) -> {
				syncSink.next(s);
				if(s.toLowerCase().equals("canada"))
					syncSink.complete();
			})
			.subscribe(Util.subscriber());

	}

}
