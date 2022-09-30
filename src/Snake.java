import java.util.Random;

public class Snake extends Monsters {
    private static Random random=new Random();
    
    
    public Snake() {
        super(4, "Yılan", 3, 12, 20);
        this.setDamage(randomSnakeDamage());
        this.setAward(randomSnakeAward());
    }

    public int randomSnakeDamage(){
        return random.nextInt(this.getDamage()) + 4; 
    }
    
    public int randomSnakeAward(){
        return random.nextInt(this.getAward());
    }
}
