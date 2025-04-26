package com.ejsjose.ecc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EccApplication {

	private static final Logger logger = LogManager.getLogger(EccApplication.class);

	public static void main(String[] args) {

		logger.trace("Mensagem de trace");
        logger.debug("Mensagem de debug");
        logger.info("Mensagem informativa");
        logger.warn("Mensagem de aviso");
        logger.error("Mensagem de erro");

		SpringApplication.run(EccApplication.class, args);
		System.out.println("Hello World");
		logger.info("Fim da execução");
	}

}
