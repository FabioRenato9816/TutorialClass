package pt.iade.unimanage.models;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student extends Person {
   private static int nextNumber = 0;
   private int number;
   @JsonIgnore
   private ArrayList<Enrolment> enrolments;

   public Student(String name, LocalDate birthDay, char gender) {
      super(name, birthDay, gender);
      this.number = nextNumber;
      nextNumber++;
      email = "";
   }

   public static int getNextNumber() {
      return nextNumber;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public LocalDate getBirthDay() {
      return birthDay;
   }

   public char getGender() {
      return gender;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   
   public Enrolment getEnrolmentByUnitId(int unitId){
     for (Enrolment enr:enrolments)
         if (enr.getUnit().getId()==unitId)return enr;
     return null;
   }
 

   public ArrayList<Enrolment> getEnrolment(){
      return enrolments;
   }
      
   public void enroll(Enrolment enrolment) {
      enrolments.add(enrolment);
      enrolment.getUnit().getEnrolments().add(enrolment);
   }

   @Override
   public String getReference() {
      return "S" + this.number;
   }

   @Override
   public String toString() {
      return "" + this.number + ": " + this.name;
   }
      

}