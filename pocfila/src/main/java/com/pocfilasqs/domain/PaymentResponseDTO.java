    package com.pocfilasqs.domain;

import java.util.UUID;

public record PaymentResponseDTO(
        UUID paymentId,
        boolean messageSend
) {
}
