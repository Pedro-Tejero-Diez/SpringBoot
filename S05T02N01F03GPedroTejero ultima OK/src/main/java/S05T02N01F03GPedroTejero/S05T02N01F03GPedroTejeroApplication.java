package S05T02N01F03GPedroTejero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication //(exclude= {SecurityAutoConfiguration.class})
//@SpringBootApplication(exclude = { DispatcherServletAutoConfiguration.class, ErrorMvcAutoConfiguration.class})

public class S05T02N01F03GPedroTejeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T02N01F03GPedroTejeroApplication.class, args);
	}

}
