package com.labs.javalabs.endpoints.cylinder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CylinderNumberBoundsException extends RuntimeException {
    private static final Logger logger = LogManager.getLogger(CylinderNumberBoundsException.class);

    public CylinderNumberBoundsException() {
        super();
        logger.error("Internal Server Error");
    }

    public CylinderNumberBoundsException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message);
    }

    public CylinderNumberBoundsException(String message) {
        super(message);
        logger.error(message);
    }

    public CylinderNumberBoundsException(Throwable cause) {
        super(cause);
        logger.error(cause.getMessage());
    }
}
