package Data;

public class Address {
    private final String street; //Строка не может быть пустой, Поле может быть null
    private final String zipCode; //Поле не может быть null

    /**
     * Адрес
     * @param street улица
     * @param zipCode код
     */
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

    /**
     * Getter street
     * @return street
     */
    public String getStreet(){
        return street;
    }

    /**
     * Getter zipCode
     * @return zipCode
     */
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
