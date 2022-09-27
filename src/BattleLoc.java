import java.util.Random;

public class BattleLoc extends Locations {
    private Monsters monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monsters monster,String award,int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award   = award;
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
                    return true;
                }
            }           
        }        
        return true;
    }

    public boolean combat(int monsterNum){    
        for(int i =1;i<=monsterNum;i++){
            this.getMonster().setHealth(this.getMonster().getOrjinalHealth());
            playerStats();
            monsterStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat=scan.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
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
                    return false;
                }
            }

            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz!");
                System.out.println(this.getMonster().getAward() + " para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel paranız :" + this.getPlayer().getMoney());
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

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
   
}   
