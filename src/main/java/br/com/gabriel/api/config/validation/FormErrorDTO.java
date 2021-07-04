package br.com.gabriel.api.config.validation;

public class FormErrorDTO {

    private final String field;
    private final String error;

    public FormErrorDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
