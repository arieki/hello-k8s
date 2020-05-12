package id.talentia.hellok8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class HelloK8sApplication {


	@RequestMapping("/")
	public String home() {
		return "Hello Docker and Kubernetes";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloK8sApplication.class, args);
	}

}
