package com.pocfilasqs.domain;

public record SendMessageRequestDTO(
        Double paymentValue,
        String creditCardNumer,
        String costumerName
) {
    @Override
    public String toString() {
        return "SendMessageRequestDTO{" +
                "paymentValue=" + paymentValue +
                ", creditCardNumer='" + creditCardNumer + '\'' +
                ", costumerName='" + costumerName + '\'' +
                '}';
    }
}
