package Java.miniquest1;
import java.util.ArrayList;

public class inventory {

    private ArrayList<item> inventoryList;

    public inventory() {
    }

    public inventory(ArrayList<item> list) {
        this.inventoryList = list; 
    }

    public ArrayList<item> getList() {
        return inventoryList;
    }

    public void setList(ArrayList<item> list) {
        this.inventoryList = list;
    } 

    public void addItem(item smth){
        inventoryList.add(smth);
    }
    
    public void removeItem(item smth){
        inventoryList.remove(smth); 
    }

    public void displayList(){
        int count = inventoryList.size(); 
        for(int x = 0; x < count; x++){
            System.out.println("\nItem " + (x + 1) + " :" + inventoryList.get(x)); 
        }
    }

    public item searchItem(String itemName){
        int count = inventoryList.size();
        item foundItem = null; 
        for(int x = 0; x < count; x++){
            if(inventoryList.get(x).getItemName().equals(itemName)){
                foundItem = inventoryList.get(x);
            }
        }
        return foundItem;
    }
}
