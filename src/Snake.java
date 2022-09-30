import java.util.Random;

public class Snake extends Monsters {

    public Snake() {
        super(4, "Yılan", 3, 12, 0);
        this.setDamage(randomSnakeDamage());
    }

    public int randomSnakeDamage(){
        Random r=new Random();
        return r.nextInt(this.getDamage()) + 4; 
    }
    
}
