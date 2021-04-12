package Data;

public class Address {
    private String street; //Строка не может быть пустой, Поле может быть null
    private String zipCode; //Поле не может быть null

    public Address(String street, String zipCode){
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Data.Address{" +
                "street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
