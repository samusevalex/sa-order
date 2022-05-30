package ru.iteco.saorder.service.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "dBAuditorAware")
@ConditionalOnProperty(prefix = "spring.datasource", name = "url")
@ConditionalOnMissingBean(value = AuditorAware.class)
public class DatabaseAutoConfiguration {
    @Bean
    public AuditorAware<String> dBAuditorAware() {
        return new DBAuditorAware();
    }
}
