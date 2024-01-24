package com.pocfilasqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentRegisterListener {

    @SqsListener("sqsPayment")
    public void listen(String message) {
        System.out.println("Mensagem recebida da fila: " + message);
    }

}
