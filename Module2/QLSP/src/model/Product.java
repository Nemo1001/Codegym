package model;

public class Product {
    private int id;
    private String name;
    private String Price;

    public Product(int id, String nameProduct) {
    }

    public Product(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.Price = price;
    }

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

    public String getPrice() {

        return Price;
    }



}
