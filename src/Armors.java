public class Armors {
    private int    id;
    private String name;
    private int    dodge;
    private int    price;

    public Armors(int id,String name,int dodge,int price){
        this.id    = id;
        this.name  = name;
        this.dodge = dodge;
        this.price = price;
    }

    public static Armors[] armors(){
        Armors[] armorsList = new Armors[3] ;
        armorsList[0] = new Armors(1, "Hafif  ", 1, 15);
        armorsList[1] = new Armors(2, "Orta   ", 3, 25);
        armorsList[2] = new Armors(3, "Ağır   ", 5, 40);
        return armorsList;
    }

    public static Armors getArmorsObjByID(int id){
        for( Armors armor : Armors.armors()){
            if(armor.getId()== id){
                return armor;
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

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
