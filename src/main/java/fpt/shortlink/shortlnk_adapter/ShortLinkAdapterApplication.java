package fpt.shortlink.shortlnk_adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ShortLinkAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortLinkAdapterApplication.class, args);
	}

}
