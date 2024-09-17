package co.com.itglobers.r2dbc.config;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;

@Configuration
@RequiredArgsConstructor
@EnableR2dbcRepositories
public class PostgreSQLConnectionPool {
	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

		var initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);

		return initializer;
	}
}
