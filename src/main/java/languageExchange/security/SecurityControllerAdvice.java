package languageExchange.security;

import languageExchange.UnAuthenticationException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.slf4j.LoggerFactory.getLogger;

@ControllerAdvice
public class SecurityControllerAdvice {
    private static final Logger log = getLogger(SecurityControllerAdvice.class);

    @ExceptionHandler(UnAuthenticationException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public String unAuthentication() {
        log.debug("UnAuthenticationException is happened!");
        return "/user/login";
    }

}
