package net.team4.mvc.model;

import java.io.FileInputStream;
import javax.swing.ImageIcon;

public class ModelPhotoPeople {
    
    private int id;
    private String dni;
    private String imagePath;
    private ImageIcon image;
    private FileInputStream imageFIS;

    public ModelPhotoPeople(int id, String dni, String imagePath) {
        this.id = id;
        this.dni = dni;
        this.imagePath = imagePath;
    }

    public ModelPhotoPeople(int id, String dni, FileInputStream imageFIS) {
        this.id = id;
        this.dni = dni;
        this.imageFIS = imageFIS;
    }

    public ModelPhotoPeople(int id, String dni, ImageIcon image) {
        this.id = id;
        this.dni = dni;
        this.image = image;
    }
    
    public ModelPhotoPeople(int id,FileInputStream imageFIS){
        this.id=id;
        this.imageFIS=imageFIS;
    }
    
    public ModelPhotoPeople(String dni, String imagePath) {
        this.dni = dni;
        this.imagePath = imagePath;
    }

    public ModelPhotoPeople(String dni, FileInputStream imageFIS) {
        this.dni = dni;
        this.imageFIS = imageFIS;
    }

    public ModelPhotoPeople(String dni, ImageIcon image) {
        this.dni = dni;
        this.image = image;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public FileInputStream getImageFIS() {
        return imageFIS;
    }

    public void setImageFIS(FileInputStream imageFIS) {
        this.imageFIS = imageFIS;
    }
}
