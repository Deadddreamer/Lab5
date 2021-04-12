package Data;

public class Coordinates {
    private Long x; //Поле не может быть null
    private Integer y; //Поле не может быть null
    public Coordinates(Long x, Integer y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Data.Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
