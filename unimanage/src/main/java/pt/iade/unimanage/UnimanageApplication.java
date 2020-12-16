package pt.iade.unimanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.iade.unimanage.Controllers.UnitRepository;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.TeacherRepository;

@SpringBootApplication
public class UnimanageApplication {

	public static void main(String[] args) {
		StudentRepository.populate();
		TeacherRepository.populate();
		UnitRepository.populate();
		SpringApplication.run(UnimanageApplication.class, args);
	}

}
