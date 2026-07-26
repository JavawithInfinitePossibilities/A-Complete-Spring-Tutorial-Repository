package com.tutorials.sid.spring;

import com.tutorials.sid.spring.services.CustomSubscriber;
import com.tutorials.sid.spring.services.OrderConsumer;
import com.tutorials.sid.spring.services.VaccineConsumer;
import com.tutorials.sid.spring.services.VaccineProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;

/**
 * Unit test for simple Division21SpringReactiveProgrammingApplication.
 */
@SpringBootTest(classes = Division21SpringReactiveProgrammingApplication.class)
public class Division21SpringReactiveProgrammingApplicationTest {
    @Autowired
    private OrderConsumer orderConsumer;
    @Autowired
    private CustomSubscriber customSubscriber;
    @Autowired
    private VaccineProvider vaccineProvider;
    @Autowired
    private VaccineConsumer vaccineConsumer;

    @Test
    void test() {
        Mono<String> mono = Mono.just("Hello World!");
        mono.log().map(s -> s.toUpperCase()).subscribe(System.out::println);
    }

    @Test
    void fluxTest() {
        Flux<String> flux = Flux.just("Hello World!", "Mac book pro", "Iphone 14 pro max");
        flux.log().map(s -> s.toUpperCase()).subscribe(System.out::println);
    }

    @Test
    void fluxOrderConsumerTest() throws InterruptedException {
        Flux.just("Hello World!", "Mac book pro", "Iphone 14 pro max")
                .delayElements(Duration.ofSeconds(2))
                .log()
                .map(s -> s.toUpperCase())
                .subscribe(new OrderConsumer());
        Thread.sleep(6000);
    }

    @Test
    void fluxIterableConsumerTest() throws InterruptedException {
        Flux.fromIterable(Arrays.asList("Hello World!", "Mac book pro", "Iphone 14 pro max"))
                .delayElements(Duration.ofSeconds(2))
                .log()
                .map(s -> s.toUpperCase())
                .subscribe(new OrderConsumer());
        Thread.sleep(6000);
    }

    @Test
    void fluxSubscriberTest() throws InterruptedException {
        Flux.fromIterable(Arrays.asList("Hello World!", "Mac book pro", "Iphone 14 pro max"))
                .delayElements(Duration.ofSeconds(2))
                .log()
                .map(s -> s.toUpperCase())
                .subscribe(customSubscriber);
        Thread.sleep(6000);
    }

    @Test
    void fluxBatchingTest() throws InterruptedException {
        Flux.fromIterable(Arrays.asList("Hello World!", "Mac book pro", "Iphone 14 pro max"))
                .delayElements(Duration.ofSeconds(2))
                .log()
                .map(s -> s.toUpperCase())
                .subscribe(customSubscriber);
        Thread.sleep(6000);
    }

    @Test
    void vaccineTest() throws InterruptedException {
        vaccineProvider.getAllVaccines()
                .delayElements(Duration.ofSeconds(1))
                .log()
                .subscribe(vaccineConsumer);
        Thread.sleep(6000);
    }
}
