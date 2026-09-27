package Java.miniquest1;

public class weapon {
    private String Name;
    private int Damage;
    
    public weapon() {
    }

    public weapon(String name, int damage) {
        Name = name;
        Damage = damage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    

    
}
