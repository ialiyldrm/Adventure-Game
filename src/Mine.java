public class Mine extends BattleLoc {

    public Mine(Player player) {
        super(player, "Maden", new Snake(), new Item("Şans"), 5);
    }
/*
Bu bölgenin amacı yenilen rakiplerden rastgele para, silah veya zırh kazanma ihtimali olması.
Yenilen bir rakiplerden düşen eşyalar :
Silah Kazanma İhtimali : 15%
Tüfek Kazanma İhtimali : 20%
Kılıç Kazanma İhtimali : 30%
Tabanca Kazanma İhtimali : 50%
Zırh Kazanma İhtimali : 15%
Ağır Zırh Kazanma İhtimali : 20%
Orta Zırh Kazanma İhtimali : 30%
Hafif Zırh Kazanma İhtimali : 50%
Para Kazanma İhtimali : 25%
10 Para Kazanma İhtimali: 20%
5 Para Kazanma İhtimali: 30%
1 Para Kazanma İhtimali: 50%
Hiç birşey kazanamama ihtimali : 45%
*/
}
