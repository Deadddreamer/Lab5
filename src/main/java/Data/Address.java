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
    public String getStreet(){
        return street;
    }
    public String getZipCode(){
        return zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return (street.equals(address.getStreet())) && (zipCode.equals(address.getZipCode()));
        }
        return false;
    }
}
