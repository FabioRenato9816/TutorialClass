package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends Person {
    private static int nextNumber = 1;
    private int mecNumber;
    private ArrayList<Unit> units;

    public Teacher (String name, LocalDate birthDay,char gender) {
        super(name, birthDay,gender);
        this.mecNumber= nextNumber;
        nextNumber++;
        units = new ArrayList<>();
    }

    public int getMecNumber(){return mecNumber;}
        
    public ArrayList<Unit> getUnits(){
        return units;
    }

    @Override
    public String getName() {
        return "Professor " + this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "" + this.mecNumber + ": " + this.name;
    }

   

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
    }

        
    @Override
    public String getReference(){return "T<"+mecNumber+">";}

    


}