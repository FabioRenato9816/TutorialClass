package pt.iade.unimanage.models;

import java.util.ArrayList;

public class Unit {
  private int id;
  private String name;
  private int credits;
  private ArrayList<Enrolment> enrolments;
  private Teacher teacher;
  public Unit(int id, String name, int credits, Teacher teacher){
     this.id=id;
     this.name=name;
     this.credits=credits; 
     enrolments = new ArrayList<Enrolment>(); 
     teacher = this.teacher;
  }
    
  public int getId(){ return id; }
  public String getName(){ return name;}
  public int getCredits(){ return credits;}
  public ArrayList<Enrolment> getEnrolments(){return enrolments;}

  public Teacher getTeacher() {
    return this.teacher;
 }

 public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
 }
}
  


