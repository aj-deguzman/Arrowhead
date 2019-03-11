package arrowhead.verfier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class InvokeVerifier {
    public static void main(String[] args) throws Exception {
	SpringApplication.run(InvokeVerifier.class, args);
    }
}
