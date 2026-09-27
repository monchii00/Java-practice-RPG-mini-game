package Java.miniquest1;

public class hero extends character {
    private weapon heroweapon; 
    private inventory backpack;

    public hero(weapon wp1, inventory backpack) {
        this.heroweapon = wp1;
        this.backpack = backpack;
    }
    public hero(String name, int health, int baseAtk, weapon wp1, inventory backpack) {
        super(name, health, baseAtk);
        this.heroweapon = wp1;
        this.backpack = backpack;
    }

    public weapon getWp1() {
        return heroweapon;
    }
    
    public void currWeap(){
        System.out.println("Hero is now holding " + heroweapon.getName());
    }

    //or EquipWp
    public void setWp1(weapon wp1) {
        this.heroweapon = wp1;
        System.out.println("Hero is now holding " + getWp1().getName());
    }
    public inventory getBackpack() {
        return backpack;
    }
    public void setBackpack(inventory backpack) {
        this.backpack = backpack;
    }

    public int totaldmg(){
        int totaldmg = getBaseAtk() + heroweapon.getDamage();
        return totaldmg;
    }

    public void attack(){
        System.out.println("Hero swings " + getWp1().getName() + " for " + totaldmg() + " Damage"); 
    }

    public void Useitem(String itemname){
        System.out.println("Hero uses " + backpack.searchItem(itemname) + "!\n" + "It " + backpack.searchItem(itemname).getItemDescription());
    }
    

    
}
