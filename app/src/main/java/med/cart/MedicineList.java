package med.cart;

public class MedicineList {
    private String Name;
    private String Price;
    private String UserId;



    public MedicineList(){

    }

    public MedicineList(String Name,String Price){
        this.Name = Name;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public void setName(String name) {
        Name = name;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
