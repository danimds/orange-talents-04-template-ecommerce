package br.com.zupacademy.dani.mercadolivre.error;

public class ErrorsDetailsDto {
    private final String reason;
    private final String error;

    public ErrorsDetailsDto(String reason, String error) {
        this.reason = reason;
        this.error = error;
    }

    public String getReason() {
        return reason;
    }

    public String getError() {
        return error;
    }
}