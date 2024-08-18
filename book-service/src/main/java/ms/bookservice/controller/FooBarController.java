package ms.bookservice.controller;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Foo bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {

    private final Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @Operation(summary = "Foo bar")
    @GetMapping("/foo-bar")
    //@Retry(name = "foo-bar", fallbackMethod = "fooBarFallBackMethod")
    //@CircuitBreaker(name = "foo-bar", fallbackMethod = "fooBarFallBackMethod")
//    @RateLimiter(name = "foo-bar", fallbackMethod = "limitedFooBar")
    public String fooBar() {
        logger.info("Request to foo-bar is received!");
        return "Hello World!";
//        var response = new RestTemplate().getForEntity("http://localhost:8080/not-found", String.class);
//        return response.getBody();
    }

//    public String limitedFooBar(RequestNotPermitted e) {
//        logger.info("Request to limited-foo-bar is received!");
//        return "you have reached the limit!";
//    }

//    public String fooBarFallBackMethod(IllegalArgumentException e) {
//        logger.info("Invoked => fooBarFallBackMethod(IllegalArgumentException e)");
//        return "Illegal arguments";
//    }
//
//    public String fooBarFallBackMethod(Exception e) {
//        logger.info("Invoked => fooBarFallBackMethod(Exception e)");
//        return "An error has occurred";
//    }
}
