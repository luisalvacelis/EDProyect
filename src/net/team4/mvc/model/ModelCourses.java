package net.team4.mvc.model;


public class ModelCourses{
    
    private int id;
    private String code;
    private String name;
    private String category;
    private String date;
    
    public ModelCourses(int id, String code, String name, String category, String date) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.category = category;
        this.date = date;
    }

    public ModelCourses(String code, String name, String category, String date) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.date = date;
    }
    
    public ModelCourses(int id){
        this.id=id;
    }

    public ModelCourses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
