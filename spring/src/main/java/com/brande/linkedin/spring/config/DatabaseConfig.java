package com.brande.linkedin.spring.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.brande.linkedin.spring.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
