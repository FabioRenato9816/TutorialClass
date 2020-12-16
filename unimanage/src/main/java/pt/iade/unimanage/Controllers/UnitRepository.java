package pt.iade.unimanage.Controllers;

import java.util.ArrayList;

import pt.iade.unimanage.models.TeacherRepository;
import pt.iade.unimanage.models.Unit;

public class UnitRepository {
    private static ArrayList<Unit> units = new ArrayList<Unit>();

    public static void populate() {
        units.add(new Unit(1, "Análise de Sistemas", 6, TeacherRepository.getTeacher(1)));
        units.add(new Unit(2, "Compiladores", 6, TeacherRepository.getTeacher(2)));
        units.add(new Unit(3, "Programação Web", 6, TeacherRepository.getTeacher(3)));
    }

    public static ArrayList<Unit> getUnits() {
        return units;
    }

    public static Unit getUnit(int unitId) {
        for (Unit unit: units)
            if (unit.getId() == unitId)
            return unit;
        return null;    
    }

    public static void removeTeacher(int unitId) {
        Unit unit = getUnit(unitId);
        
        unit.setTeacher(null);
	}

}
