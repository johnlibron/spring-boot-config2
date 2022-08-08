package com.example.demo;

import com.example.demo.LegacyPaymentsService;
import com.example.demo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class SystemConfig {

    private final UsersRepository usersRepository;

    @Autowired
    public SystemConfig(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Bean
    public UsersRepository usersRepository() {
        return usersRepository;
    }

    @Bean
    public LegacyPaymentsService paymentsService() {
        return new LegacyPaymentsService();
    }
}
