package br.com.gabriel.api.config.validation;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    private static final String INVALID_TYPE_ERROR = "O tipo informado não é válido!";

    private final MessageSource messageSource;

    public ValidationErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormErrorDTO> handle(MethodArgumentNotValidException exception) {
        List<FormErrorDTO> dtos = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            FormErrorDTO errorDTO = new FormErrorDTO(e.getField(), message);
            dtos.add(errorDTO);
        });

        return dtos;
    }

    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(InvalidFormatException.class)
    public FormErrorDTO handle(InvalidFormatException exception) {

        return new FormErrorDTO(getInvalidFormatExceptionFieldName(exception), INVALID_TYPE_ERROR);
    }

    private String getInvalidFormatExceptionFieldName(InvalidFormatException ex) {

        for (JsonMappingException.Reference r : ex.getPath()) {
            return r.getFieldName();
        }

        return null;
    }

}
