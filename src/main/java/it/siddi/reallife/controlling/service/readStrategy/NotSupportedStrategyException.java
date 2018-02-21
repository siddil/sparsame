package it.siddi.reallife.controlling.service.readStrategy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="To show an example of a custom message")
public class NotSupportedStrategyException extends Throwable {
}
