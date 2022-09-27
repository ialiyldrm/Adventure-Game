public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
        
    }

    @Override
    public boolean onLocation() {
        System.out.println("----------Mağazaya Hoşgeldiniz!----------");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 - Silahlar  ");
            System.out.println("2 - Zırhlar  ");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçiminiz:");
            int selectCase = Locations.scan.nextInt();
            while(selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer,tekrar giriniz : ");
                selectCase = scan.nextInt();          
            }
            switch(selectCase){
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    
    public void printWeapons(){
        System.out.println();
        System.out.println("----------Silahlar----------");
        for (Weapons w : Weapons.weapons()) {
            System.out.println(w.getId()+ "-" + w.getName() + " < Para : " + w.getPrice() + ", Hasar : " + w.getDamage());
        }
        System.out.println("0 - Çıkış Yap!"); 
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz: ");
        
        int selectWeaponId = scan.nextInt();
        
        while(selectWeaponId < 0 || selectWeaponId > Weapons.weapons().length){
            System.out.println("Geçersiz değer,tekrar giriniz : ");
            selectWeaponId = scan.nextInt();          
        }

        if(selectWeaponId != 0){
            Weapons selectedWeapon = Weapons.getWeaponsObjByID(selectWeaponId);
        
            if( selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır!");                
                }else{
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInv().setWeapon(selectedWeapon);
                }
            }
        }
        
    }

    public void printArmors(){
        System.out.println("Zırhlar");
        for (Armors armor : Armors.armors()) {
            System.out.println(armor.getId()+ "-" + armor.getName() + " < Para : " 
                            + armor.getPrice() + ", Zırh : " + armor.getDodge());
        }
        System.out.println("0 - Çıkış Yap!");
    }
    
    public void buyArmor(){
        System.out.print("Bir zırh seçiniz: ");
        
        int selectArmorId = scan.nextInt();
        
        while(selectArmorId < 0 || selectArmorId > Armors.armors().length){
            System.out.println("Geçersiz değer,tekrar giriniz : ");
            selectArmorId = scan.nextInt();          
        }

        if(selectArmorId != 0){
            Armors selectedArmor = Armors.getArmorsObjByID(selectArmorId);
        
            if( selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır!");                
                }else{
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInv().setArmor(selectedArmor);
                }
            }
        }
    }
}
