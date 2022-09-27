import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String  charName;
    private String name;
    private Scanner scan=new Scanner(System.in);
    private Inventory inv;
    
    
    public Player(String name){
        this.name= name;
        this.inv = new Inventory();
    }

    public void selectChar(){       
        GameChar[] charlist = {new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler:");
        System.out.println("--------------------------------------------------------------------------");
        for (GameChar gameChar : charlist) {
            System.out.println("ID: " + gameChar.getId() +
                            "\t Karakter : "+ gameChar.getName() + 
                            "\t Hasar: " + gameChar.getDamage() + 
                            "\t Sağlık: " + gameChar.getHealth() + 
                            "\t Para: "  + gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------------------------"); 
        System.out.print("Lütfen bir karakter seçiniz!:");
        int selectChar = scan.nextInt();
        System.out.println();
        switch(selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter  : " + this.getCharName() + 
                ", Hasar :" + this.getDamage() + 
                ", Sağlık :" + this.getHealth() +
                ", Para :" + this.getMoney());
    }
  
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                "Silah     : " + this.getInv().getWeapon().getName() +
                ", Hasar :" + this.getTotalDamage() +
                ", Zırh : " + this.getInv().getArmor().getDodge() + 
                ", Sağlık :" + this.getHealth() +
                ", Para :" + this.getMoney());
        

    }

    public int getTotalDamage(){
        return damage + this.getInv().getWeapon().getDamage();
    }
    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage=damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health=health;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName){
        this.charName=charName;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
