package com.coralogix.calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.CompositeDatabasePopulator;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.web.client.RestTemplate;

import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ConnectionFactoryInitializer databaseInitializer(ConnectionFactory connectionFactory) {
		
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		
		CompositeDatabasePopulator populator = new CompositeDatabasePopulator();
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema/schema.sql")));
		populator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema/data.sql")));
		initializer.setDatabasePopulator(populator);
		
		return initializer;
	}
}
