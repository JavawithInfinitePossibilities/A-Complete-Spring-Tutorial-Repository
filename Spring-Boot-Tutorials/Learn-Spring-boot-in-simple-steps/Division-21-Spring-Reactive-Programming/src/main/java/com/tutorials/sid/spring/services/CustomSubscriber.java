package com.tutorials.sid.spring.services;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author kunmu On 26-07-2026
 */
@Service
public class CustomSubscriber implements Subscriber<String> {

    private long count = 0;
    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
        s.request(2);
    }

    @Override
    public void onNext(String s) {
        System.out.println("Received: " + s);
        count++;
        if (count >= 2) {
            subscription.request(2);
        }
    }

    @Override
    public void onError(Throwable t) {
        System.err.println("Error occurred: " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }
}
