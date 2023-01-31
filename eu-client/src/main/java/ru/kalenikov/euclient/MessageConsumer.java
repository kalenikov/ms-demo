package ru.kalenikov.euclient;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class MessageConsumer {
    @StreamListener(target = Sink.INPUT)
    public void input(String payload) throws Exception {
        throw new Exception("test ex");
//        System.out.println(payload);
    }
}
