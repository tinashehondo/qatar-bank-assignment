package za.co.qdb.microservice.documents.api.config;

import feign.Contract;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
public class AppConfig {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}

