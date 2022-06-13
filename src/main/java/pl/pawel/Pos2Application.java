package pl.pawel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class Pos2Application {

    public static void main(String[] args) {
        SpringApplication.run(Pos2Application.class, args);
    }

}
