package com.ha.studentmanager.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ha.studentmanager.model.Student;
import com.ha.studentmanager.repository.StudentRepository;

@Configuration
public class Database {
	private static final Logger LOGGER = LoggerFactory.getLogger(Database.class);

	@Bean
	CommandLineRunner initDatabaseUser(StudentRepository studentRepository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Student studentA = new Student(1L, "Nguyen Van A", true, new Date(), "Hanoi", "17 pho hien", "Anh Văn");
				LOGGER.info("insert data: " + studentRepository.save(studentA));

			}
		};
	}
}
