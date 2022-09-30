import java.util.ArrayList;

public class Inventory {
    private Weapons weapon;
    private Armors   armor;
    private ArrayList<Item> itemList;
    
    public Inventory() {
        this.weapon = new Weapons(-1,"Yumruk", 0, 0);
        this.armor  = new Armors(-1,"Yok", 0, 0);
        this.itemList = new ArrayList<Item>();
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Item item) {
        this.itemList.add(item);
    }   
}
