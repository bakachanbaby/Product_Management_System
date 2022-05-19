package nhom15.entity;

import javax.persistence.*;

//Gán là 1 entity
@Entity
//Khai báo đây là bảng students
@Table(name = "tblproduct")
public class Products {

    //Khóa chính
    @Id
    //Tự tăng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String code;

    private String description;

    private float price;

    public Products() {
    }

    public Products(String code, String description, float price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
