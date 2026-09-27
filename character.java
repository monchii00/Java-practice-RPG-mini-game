package Java.miniquest1;

public abstract class character {
    private String Name;
    private int Health;
    private int BaseAtk;
    
    public character() {
    }

    public character(String name, int health, int baseAtk) {
        Name = name;
        Health = health;
        BaseAtk = baseAtk;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getBaseAtk() {
        return BaseAtk;
    }

    public void setBaseAtk(int baseAtk) {
        BaseAtk = baseAtk;
    }
    
    public void Takedmg(int damage){
        this.Health = this.Health - damage; 
    }

    public boolean isAlive(){
        boolean alive = false; 
        return alive = (this.Health > 0) ? true : false; 
    }
    

    //abstract - every character must be able to attack but how will
    //be decided depending on the character. its only a blueprint 
    public abstract void attack(); 
}
