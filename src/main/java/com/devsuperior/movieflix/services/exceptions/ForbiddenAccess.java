package com.devsuperior.movieflix.services.exceptions;

import java.io.Serial;

public class ForbiddenAccess extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ForbiddenAccess(String msg) {
        super(msg);
    }
}
