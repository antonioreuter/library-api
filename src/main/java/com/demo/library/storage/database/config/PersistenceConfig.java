package com.demo.library.storage.database.config;


import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.demo.library.storage.database.jpa")
public class PersistenceConfig {
}
