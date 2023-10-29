package TP3.Polling.App.Security;

import TP3.Polling.App.Models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SessionConfiguration {
    @Bean
    public Map<String, User> sessions() {
        return new ConcurrentHashMap<>();
    }
}
