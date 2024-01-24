package com.pocfilasqs.domain;

import java.util.UUID;

public record PaymentDTO(
        UUID paymentId,
        Double paymentValue,
        String creditCardNumer,
        String costumerName
) {
    @Override
    public String toString() {
        return "paymentId=" + paymentId +
                ", paymentValue=" + paymentValue +
                ", creditCardNumer='" + creditCardNumer + '\'' +
                ", costumerName='" + costumerName + '\'';
    }
}
