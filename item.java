package Java.miniquest1; 

public class item{

    private String itemName; 
    private String itemDescription; 
    private int price;
    
    public item() {
    }

    public item(String itemName, String itemDescription, int price) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name:" + itemName + "\n" + "Description:" + itemDescription + "\n" +  "price:" + price;
    }

    

    

}