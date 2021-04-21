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
    public Long getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinatesObj = (Coordinates) obj;
            return (x == coordinatesObj.getX()) && y.equals(coordinatesObj.getY());
        }
        return false;
    }
}
