package com.pocfilasqs.producer.impl;

import com.pocfilasqs.domain.PaymentDTO;
import com.pocfilasqs.domain.PaymentResponseDTO;
import com.pocfilasqs.domain.SendMessageRequestDTO;
import com.pocfilasqs.producer.PaymentProducer;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentProducerImpl implements PaymentProducer {

    private final SqsTemplate sqsTemplate;

    public PaymentProducerImpl(SqsTemplate sqsTemplate){
        this.sqsTemplate = sqsTemplate;
    }


    @Override
    public PaymentResponseDTO sendMessage(SendMessageRequestDTO sendMessageRequestDTO) {
        System.out.println("Enviando a mensagem: " + sendMessageRequestDTO.toString());
        PaymentDTO paymentDTO = new PaymentDTO(
                UUID.randomUUID(),
                sendMessageRequestDTO.paymentValue(),
                sendMessageRequestDTO.creditCardNumer(),
                sendMessageRequestDTO.costumerName()
        );
        String queueName = "sqsPayment";
        sqsTemplate.send(queueName, paymentDTO.toString());
        return new PaymentResponseDTO(
                UUID.randomUUID(),
                true
        );
    }
}
