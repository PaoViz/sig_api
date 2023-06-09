package ec.edu.insteclrg.sig_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@ComponentScan({ "ec.edu.insteclrg.sig_api" })
@EnableJpaRepositories(basePackages = { "ec.edu.insteclrg.sig_api.persistence" })
@EntityScan(basePackages = { "ec.edu.insteclrg.sig_api.domain" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
@OpenAPIDefinition(
		info=@Info(
				title="SIG_API",
				version="1.0.0",
				description="Sistema Integral de Gestión - API",
				termsOfService = "",
				contact=@Contact(
						name="Luis Quishpi",
						email="luis.quishpi@insteclrg.edu.ec, luis.quishpi@gmail.com"
						),
				license=@License(
						name="Licencia",
						url="https://instelrg.edu.ec"
						)
				))
public class SigApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigApiApplication.class, args);
	}

}
