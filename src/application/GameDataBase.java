package application;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class GameDataBase implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
    private long id;

    private int x;
    private int y;

    public GameDataBase() {
    }

    GameDataBase(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public int getX() {
         return x;
    }

    public int getY() {
         return y;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }
	
}
