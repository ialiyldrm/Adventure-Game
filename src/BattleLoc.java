import java.util.Random;

public class BattleLoc extends Locations {
    private Monsters monster;
    private Item item;
    private int maxMonster;
    private static boolean LocSituation=false;//Canavar olan bölgeler güvenli değil.Canavar varsa false yoksa true döndürüyor.

    public BattleLoc(Player player, String name, Monsters monster,Item item,int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.item = item;
        this.maxMonster = maxMonster;       
    }

    @Override
    public boolean onLocation() {
        
        int monsterNum = this.randomMonsterNumber();
        System.out.println("Şu an buradasınız : " + this.getName());
        System.out.println("Dikkatli ol!!! Burada " + monsterNum + " tane " + this.getMonster().getName() + " yaşıyor!!!");
        System.out.print("<S>avaş veya <K>aç : ");

        String selectCase = scan.nextLine().toUpperCase();

        if(selectCase.equals("S")){
            if(combat(monsterNum)){   
                if(this.getPlayer().getHealth() <= 0){
                    System.out.println("Öldünüz!");
                    return false;
                }else{
                    System.out.println(this.getName() + " tüm düşmanları yendiniz!");
                    if(!this.getName().equals("Maden")){
                        System.out.println(this.item.getName() + " ödülünü kazandınız.");                       
                        this.getPlayer().setItemNumber(this.getPlayer().getItemNumber()+1);
                        
                    }
                    if(this.getPlayer().getItemNumber()==3){
                        System.out.println("Tüm itemleri topladınız.Oyunu kazanmak için Güvenli Ev'e gidiniz! ");
                    }
                    setLocSituation(true);
                    isDelete();
                    this.getPlayer().setLocBlok(true);
                    return true;
                }
            }           
        }else{
            System.out.println("Tüm canavarlardan kaçarak item kazanamazsınız!");
            System.out.println("Şu ana kadar " + this.getPlayer().getItemNumber() + " tane item topladınız!");
            System.out.println("Bölgeye tekrar gelip tüm canavarlarla savaşınız!"); 
        }        
        return true;
    }

    public boolean combat(int monsterNum){    
        for(int i =1;i<=monsterNum;i++){
            this.getMonster().setHealth(this.getMonster().getOrjinalHealth());
            System.out.println();
            playerStats();
            monsterStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat=scan.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    double whoIsStart=Math.random()*100;// Oyuncu bir canavarla karşılaştığında ilk hamleyi kimin yapacağını, %50 şans ile belirleyen kod satırı
                    if(whoIsStart<=50){
                        System.out.println("Siz Canavara Vurdunuz!");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getMonster().getHealth() > 0){
                            System.out.println();
                            System.out.println("Canavar Size Vurdu!");
                            int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInv().getArmor().getDodge();
                            if(monsterDamage < 0){
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage );
                            afterHit();
                        }
                    }else{
                        System.out.println("Canavar Size Vurdu!");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInv().getArmor().getDodge();
                        if(monsterDamage < 0){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage );
                        afterHit();
                        if(this.getPlayer().getHealth()>0){
                            System.out.println();
                            System.out.println("Siz Canavara Vurdunuz!");
                            this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }                                      
                }else{
                    System.out.println("Tüm canavarları yenmeden item kazanamazsınız!");
                    System.out.println("Şu ana kadar " + this.getPlayer().getItemNumber() + " tane item topladınız!");
                    System.out.println("Bölgeye tekrar gelip tüm canavarlarla savaşınız!");
                    return false;
                }
            }

            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz!");
                if(this.getMonster().getName().equals("Yılan")){
                    //buraya para veya envanter kazanma olasılığına göre metod gelecek
                    this.getPlayer().awardForMine(this.getMonster().getAward());
                    
                }else{
                    System.out.println(this.getMonster().getAward() + " para kazandınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                    System.out.println("Güncel paranız :" + this.getPlayer().getMoney());                   
                }                
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName()+ " canı: " + this.monster.getHealth());
        System.out.println("-------------------------");
    }

    public void playerStats(){
        System.out.println("Oyuncu değerleri");
        System.out.println("--------------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInv().getWeapon().getName());
        System.out.println("Zırh  : " + this.getPlayer().getInv().getArmor().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Blok  : " + this.getPlayer().getInv().getArmor().getDodge());
        System.out.println("Para  : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void  monsterStats(int i){
        System.out.println(i + "." + this.getMonster().getName() + " Değerleri");
        System.out.println("--------------------------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar  : " + this.getMonster().getDamage());
        System.out.println("Ödül   : " + this.getMonster().getAward());
        System.out.println();
    }
    public static void isDelete() {
        if(getLocSituation()){
            System.out.println("Bölgedeki tüm canavarlar öldü.Bu bölgeye erişemezsiniz.Başka bölge seçiniz");
        }    
    }

    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;

    }

    public Monsters getMonster() {
        return monster;
    }

    public void setMonster(Monsters monster) {
        this.monster = monster;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public static boolean getLocSituation() {
        return LocSituation;
    }

    public static void setLocSituation(boolean locSituation) {
        LocSituation = locSituation;
    }
    
    
}   
