public class Weapons {
    private int id;
    private String name;
    private int damage;
    private int price;
    
    public Weapons(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapons[] weapons(){
        Weapons[] weaponsList = new Weapons[3] ;
        weaponsList[0] = new Weapons(1, "Tabanca", 2, 15);
        weaponsList[1] = new Weapons(2, "Kılıç  ", 3, 35);
        weaponsList[2] = new Weapons(3, "Tüfek  ", 7, 45);
        return weaponsList;
    }

    public static Weapons getWeaponsObjByID(int id){
        for( Weapons w : Weapons.weapons()){
            if(w.getId()== id){
                return w;
            }
        }
        return null;
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

    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }
    
}
