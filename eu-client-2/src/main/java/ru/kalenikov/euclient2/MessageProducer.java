package ru.kalenikov.euclient2;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class MessageProducer {
    private final Source outputBinding;

    public MessageProducer(Source outputBinding) {
        this.outputBinding = outputBinding;
    }

    public void send() {
        Message<String> msg = MessageBuilder.withPayload("hello").build();
        outputBinding.output().send(msg);
    }
}
