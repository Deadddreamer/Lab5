package Data;

public class Coordinates {
    private final Long x; //Поле не может быть null
    private final Integer y; //Поле не может быть null

    /**
     * Координаты
     * @param x координата x
     * @param y координата y
     */
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

    /**
     * Getter x
     * @return x
     */
    public Long getX(){
        return x;
    }

    /**
     * Getter y
     * @return y
     */
    public Integer getY(){
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinatesObj = (Coordinates) obj;
            return (x.equals(coordinatesObj.getX())) && y.equals(coordinatesObj.getY());
        }
        return false;
    }
}
