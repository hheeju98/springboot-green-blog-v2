package site.metacoding.blogversion2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogVersion2Application {

	public static void main(String[] args) {
		SpringApplication.run(BlogVersion2Application.class, args);
	}

}
