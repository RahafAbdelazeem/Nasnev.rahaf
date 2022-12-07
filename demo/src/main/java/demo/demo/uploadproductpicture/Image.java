package demo.demo.uploadproductpicture;

import javax.persistence.*;

@Entity
@Table(name ="image_model")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;


    private String category;
     @Column(length = 5000000)
     private byte[] picByte;
    public Image() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public Image(String name, String category, byte[] picByte) {
        this.name = name;
        this.category = category;
        this.picByte = picByte;
    }
}
