package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeacherRepository {
    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void populate() {
        Teacher t;
        t = new Teacher ("Carlos", LocalDate.parse("1970-12-23"), 'M');
        teachers.add(t);
        teachers.add(new Teacher ("Raquel", LocalDate.parse("1980-06-12"), 'F'));
        teachers.add(new Teacher ("Tiago", LocalDate.parse("1985-02-10"), 'M'));
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public static Teacher getTeacher (int mecNumber) {
        for (Teacher teacher: teachers)
            if (teacher.getMecNumber() == mecNumber)
                return teacher;

        return null;        
    }

    public static ArrayList<Unit> getUnits (int mecNumber) {
        for (Teacher teacher: teachers)
            if (teacher.getMecNumber() == mecNumber) 
                return teacher.getUnits();

        return null;        
    }
}

    