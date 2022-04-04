package com.rp.sec12;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Ctx {

    public static void main(String[] args) {

        getWelcomeMessage()
//        	.contextWrite(Context.of("users", "jake"))
        	.contextWrite(Context.of("user", "jake"))
        	.contextWrite(Context.of("user", "sam"))
            .subscribe(Util.subscriber());

    }

    private static Mono<String> getWelcomeMessage(){
//        return Mono.fromSupplier(() -> "Welcome");
    	return Mono.deferContextual(ctx -> {
            if(ctx.hasKey("user")){
                return Mono.just("Welcome  " + ctx.get("user"));
            }else{
                return Mono.error(new RuntimeException("unauthenticated"));
            }
        });
    }
}
