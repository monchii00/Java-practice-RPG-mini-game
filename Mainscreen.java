package Java.miniquest1;

import java.util.ArrayList;

public class Mainscreen{
    public static void main(String[] args){
//step 1: Item class
        System.out.println("<!---Item class section---!>"); 
        item healItem1 = new item("Health potion", "Heals player", 50); 
        System.out.println("Using toString from item class:"); 
        System.out.println("Item 1:" + "\n" + healItem1);
        
        System.out.println("\nUsing methods from item class:"); 
        System.out.println(healItem1.getItemName());
        System.out.println(healItem1.getItemDescription());
        System.out.println(healItem1.getPrice());
        
//step 2: Weapon class
        System.out.println("\n<!---Weapon class section---!>"); 
        weapon weap1 = new weapon("Excalibur", 20); 

        System.out.println("Level 1:");
        System.out.println("Weapon 1:" +  weap1.getName() + "\n" + "Weapon Damage: " + weap1.getDamage()); 
        weap1.setDamage(30);
        System.out.println("Level 2:");
        System.out.println("Weapon 1:" +  weap1.getName() + "\n" + "Weapon Damage: " + weap1.getDamage()); 

//step 4: Hero class; 
        System.out.println("\n<!---Hero class section---!>");

        ArrayList<item> heroList = new ArrayList<item>();
        inventory hero1Inv = new inventory(heroList);

        hero Warrior = new hero("Warrior", 50, 10, weap1, hero1Inv);
        weapon weap2 = new weapon("Warrior's sword", 35); 
        Warrior.currWeap();
        Warrior.attack();
        Warrior.setWp1(weap2);
        Warrior.attack();
        System.out.println(Warrior.isAlive());


//step 7: Inventory class
        System.out.println("\n<!---Inventory class section---!>"); 

        item food1 = new item("Beef", "Fills up player's hunger", 15);
        item ring1 = new item("Magic ring", "Increases player Mana", 300); 
        //creates the actual list
        ArrayList<item> itemlist = new ArrayList<item>();
        //puts it inside a box named inventory datatype list1; //struct box
        inventory list1 = new inventory(itemlist);
        
    
        list1.addItem(healItem1);
        list1.addItem(food1);
        list1.addItem(ring1);

        System.out.println("Player1's Inventory: ");
        list1.displayList();

        System.out.println("\nRemove the food");
        System.out.println("\nPlayer1's Inventory: ");
        list1.removeItem(food1);
        list1.displayList();
    }

}