package pt.iade.unimanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.iade.unimanage.models.StudentRepository;

@SpringBootApplication
public class UnimanageApplication {

	public static void main(String[] args) {
		StudentRepository.populate();
		SpringApplication.run(UnimanageApplication.class, args);
	}

}
