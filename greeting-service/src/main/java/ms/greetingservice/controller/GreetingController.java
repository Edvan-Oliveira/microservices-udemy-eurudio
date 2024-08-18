package ms.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import lombok.RequiredArgsConstructor;
import ms.greetingservice.configuration.GreetingConfiguration;
import ms.greetingservice.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GreetingController {

	private final GreetingConfiguration configuration;

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "") String name) {

		if (name.isEmpty()) {
			name = configuration.getDefaultValue();
		}

		return new Greeting(counter.incrementAndGet(), String.format(template, configuration.getGreeting(), name));
	}
}
