package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lec05VirtualTimeTest {

    @Test
    public void test1(){
/*
    	StepVerifier.create(timeConsumingFlux())
    	.expectNext("1a", "2a", "3a", "4a")
        .verifyComplete();
*/    	
        StepVerifier.withVirtualTime(() -> timeConsumingFlux())
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a", "2a", "3a", "4a")
                .verifyComplete();
    }

    private Flux<String> timeConsumingFlux(){
        return Flux.range(1, 4)
                    .delayElements(Duration.ofSeconds(5))
                    .map((i -> i + "a"));
    }

}
