package com.labs.javalabs.cylinder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.LogManager;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CylinderNumberBoundsException extends RuntimeException {
    private static final Logger logger = LogManager.getLogger(LogBuilder.class);

    public CylinderNumberBoundsException() {
        super();
        logger.warn("Internal Server Error");
    }

    public CylinderNumberBoundsException(String message, Throwable cause) {
        super(message, cause);
        logger.warn(message);
    }

    public CylinderNumberBoundsException(String message) {
        super(message);
        logger.warn(message);
    }

    public CylinderNumberBoundsException(Throwable cause) {
        super(cause);
        logger.warn(cause.getMessage());
    }
}
