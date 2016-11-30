package BaseOfData.entitys;

/**
 * Created by nikk on 12.11.2015.
 */
public class Product {
    private String pet;
    private String typeOfProduct;
    private String nameOfProduct;
    private String description;
    private String price;
    private int id;
    private String image;

    public Product(String pet, String typeOfProduct, String nameOfProduct, String description, String price, int id, String image){
        this.pet = pet;
        this.typeOfProduct = typeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.description = description;
        this.price = price;
        this.id = id;
        this.image = image;
    }

    public Product(String pet, String typeOfProduct, String nameOfProduct, String description, String price, String image){
        this.pet = pet;
        this.typeOfProduct = typeOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getPet() {
        return pet;
    }

    public String getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
