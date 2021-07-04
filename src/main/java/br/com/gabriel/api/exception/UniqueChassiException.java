package br.com.gabriel.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UniqueChassiException extends ResponseStatusException {

    public UniqueChassiException(HttpStatus status, String reason) {
        super(status, reason);
    }

}
