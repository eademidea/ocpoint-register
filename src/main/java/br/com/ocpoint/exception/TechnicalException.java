package br.com.ocpoint.exception;

import java.io.Serial;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TechnicalException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(String message) {
        super(message);
    }

}