package dev.ledesma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason="Points Cannot Be Negative")
public class PointsAreNegativeException extends RuntimeException{
}
