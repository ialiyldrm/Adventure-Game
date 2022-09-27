import java.util.Scanner;

public class Game {
    private Scanner scan=new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz!");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = scan.nextLine();
        System.out.println();
        Player player= new Player(playerName);
        System.out.println("Sayın " + player.getName() + " adaya hoşgeldiniz !");
        System.out.println("Bir karakter seçiniz");
        player.selectChar();
        
        Locations location = null;
        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("*******************************Bölgeler*******************************");
            System.out.println("1- Güvenli Ev ---> Burası sizin için güvenli ev,düşman yoktur !");
            System.out.println("2- Dükkan     ---> Silah veya zırh satın alabilirsiniz !"); 
            System.out.println("3- Mağara     ---> Ödül <Yemek>, dikkatli ol karşına zombi çıkabilir!");
            System.out.println("4- Orman      ---> Ödül <Odun> , dikkatli ol karşına vampir çıkabilir!");
            System.out.println("5- Nehir      ---> Ödül <Su>   , dikkatli ol karşına ayı çıkabilir!");
            System.out.println("0- Çıkış      ---> Oyunu sonlandır! ");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation=scan.nextInt();
            switch(selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz!");;
            }

            if(location == null){
                System.out.println("Oyundan çıkılıyor!");
                break;
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER!!!");
                break;
            }
        }
    }
}
