package com.pocfilasqs.producer;

import com.pocfilasqs.domain.PaymentResponseDTO;
import com.pocfilasqs.domain.SendMessageRequestDTO;

public interface PaymentProducer {
    PaymentResponseDTO sendMessage(SendMessageRequestDTO sendMessageRequestDTO);
}
