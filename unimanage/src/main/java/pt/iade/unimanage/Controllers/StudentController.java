package pt.iade.unimanage.Controllers;

import java.util.ArrayList;
//import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.unimanage.models.Enrolment;
import pt.iade.unimanage.models.Student;
import pt.iade.unimanage.models.StudentRepository;
import pt.iade.unimanage.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
    private java.util.logging.Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Student> getStudents() {
        logger.info("Sending all students");
        return StudentRepository.getStudents();
    }

    public Student getStudent(@PathVariable("number") int number) throws NotFoundException {
        logger.info("Sending student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (student != null)
            return student;
        else
            throw new NotFoundException("" + number, "Student", "number");
    }

    @DeleteMapping(path = "apagar/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteStudent(@PathVariable("number") int number) {
        logger.info("deleting student with number " + number);
        Student student = StudentRepository.getStudent(number);
        if (StudentRepository.deleteStudent(number))
            return new Response(number + " was deleted.", student);
        else
            return new Response(number + " not found.", student);
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {
        return StudentRepository.addStudent(student);

    }

    @GetMapping(path ="/{number}/enrolments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Enrolment> getEnrolments(@PathVariable("number") int number) throws NotFoundException {
        logger.info("Sending all enrolments of a student" +number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) return student.getEnrolment();
        else throw new NotFoundException(""+number, "Student", "number");
    }

    @GetMapping(path ="/{number}/enrolments/{unitId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment getEnrolment(@PathVariable("number") int number, @PathVariable("unitId") int unitId) throws NotFoundException{
        logger.info("Sending enrolment with id" +unitId + "of student with number" +number);
        Student student = StudentRepository.getStudent(number);
        if (student != null){
            Enrolment enr = student.getEnrolmentByUnitId(unitId);
            if (enr != null) return enr;
            else throw new NotFoundException (""+unitId, "Unit","id");
        } else throw new NotFoundException (""+number, "Student", "number");
    }

    @PostMapping(path = "/{number}/enrolments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Enrolment addEnrolment(@PathVariable("number") int number, @RequestBody int unitId) 
    throws NotFoundException, AlreadyExistsException{
        logger.info("Enroling student with number" +number+ "in unit with id" +unitId);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Unit unit = UnitRepository.getUnit(unitId);
            if (unit != null) {
                if(student.getEnrolmentByUnitId(unitId) != null)
                    throw new AlreadyExistsExceptionn(""+unitId, "Unit", "id");
                else {
                    Enrolment enrolment = new Enrolment(student,unit,-1);
                    student.enroll(enrolment);
                    return enrolment;
                }
            } else throw new NotFoundException(""+unitId, "Unit", "id");
        } else throw new NotFoundException(""+number, "Student", "number");    
    }


    @PutMapping(path = "{number}/enrolments/{unitId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Enrolment setGrade(@PathVariable("number") int number, @PathVariable("unitId") int unitId, @RequestBody double grade)
    throws NotFoundException{
        logger.info("Setting grade of enrolment with id "+unitId+ " of student with number "+number);
        Student student = StudentRepository.getStudent(number);
        if (student != null) {
            Enrolment enr = student.getEnrolmentByUnitId(unitId);
            if (enr != null) {
                enr.setGrade(grade);
                return enr;
            } else throw new NotFoundException(""+unitId, "Unit", "id");
        } else throw new NotFoundException(""+number, "Student", "number");
    }
}
