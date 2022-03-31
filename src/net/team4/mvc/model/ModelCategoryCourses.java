package net.team4.mvc.model;

public class ModelCategoryCourses{
    
    private int id;
    private String name;
    private String observation;
    private String date;

    public ModelCategoryCourses(int id, String name, String observation,String date) {
        this.id = id;
        this.name = name;
        this.observation = observation;
        this.date=date;
    }

    public ModelCategoryCourses(String name, String observation,String date) {
        this.name = name;
        this.observation = observation;
        this.date=date;
    }

    public ModelCategoryCourses(int id) {
        this.id = id;
    }

    public ModelCategoryCourses() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date=date; 
    }
}
