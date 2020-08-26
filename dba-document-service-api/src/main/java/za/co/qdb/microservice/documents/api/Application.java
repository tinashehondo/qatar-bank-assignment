package za.co.qdb.microservice.documents.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableFeignClients
public class Application {

    public static void main(final String[] args) {

        final SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pid.txt"));
        springApplication.run(args);
    }
}
