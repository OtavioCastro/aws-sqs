package com.pocfilasqs.controller;

import com.pocfilasqs.domain.PaymentResponseDTO;
import com.pocfilasqs.domain.SendMessageRequestDTO;
import com.pocfilasqs.producer.PaymentProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("queue")
public class SQSController {

    private final PaymentProducer paymentProducer;

    public SQSController(PaymentProducer paymentProducer){
        this.paymentProducer = paymentProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<PaymentResponseDTO> sendMessage(@RequestBody SendMessageRequestDTO sendMessageRequestDTO){
        PaymentResponseDTO paymentResponseDTO = paymentProducer.sendMessage(sendMessageRequestDTO);
        return ResponseEntity.ok(paymentResponseDTO);
    }
}
