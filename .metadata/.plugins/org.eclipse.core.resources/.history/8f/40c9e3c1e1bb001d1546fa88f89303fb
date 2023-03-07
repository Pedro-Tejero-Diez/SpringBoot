package cat.itacademy.S04T01N01PedroTejero.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	 @GetMapping("/HelloWorld")
	    public String saluda(@RequestParam(value = "name", defaultValue = "unknown") String name) {
	      return String.format("Hello %s! estás ejecutando un proyecto Maven", name);
	    }

}

