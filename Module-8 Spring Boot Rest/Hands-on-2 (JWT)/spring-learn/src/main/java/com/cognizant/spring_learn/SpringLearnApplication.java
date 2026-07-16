package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class SpringLearnApplication {
	// Gets a Logger associated with SpringLearnApplication class
	private static Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayCountries() {
		LOGGER.info("START");

		// Initialises All Beans
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries = context.getBean("countryList", List.class);

		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");

	}

	public static void displayCountry() {

		LOGGER.info("START");

		// Create Country Object
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country" ,Country.class);
		LOGGER.debug("Country : {}", country.toString());


		LOGGER.info("END");

	}

	public static void displayDate() throws ParseException {
		LOGGER.info("START");

		// Create object for SimpleDateFormat
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		Date date = format.parse("31/12/2018");
		LOGGER.debug("Parsed Date: {}", date);


		LOGGER.info("END");

	}

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();

		displayCountry();
		displayCountries();
	}

}
