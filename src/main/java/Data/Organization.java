package Data;

import Data.OrganizationType;

import java.time.ZonedDateTime;
    public class Organization {
        private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private int annualTurnover; //Значение поля должно быть больше 0
        private long employeesCount; //Значение поля должно быть больше 0
        private OrganizationType type; //Поле не может быть null
        private Address postalAddress; //Поле не может быть null

        public Organization (Integer id, String name, Coordinates coordinates, int annualTurnover, long employeesCount, OrganizationType type, Address postalAddress, ZonedDateTime zonedDateTime){
            this.id = id;
            this.name = name;
            this.coordinates = coordinates;
            this.annualTurnover = annualTurnover;
            this.employeesCount = employeesCount;
            this.type = type;
            this.postalAddress = postalAddress;
            this.creationDate = zonedDateTime;
        }

        public Integer getId() {
            return id;
        }
        public String getName(){
            return name;
        }
        public Coordinates getCoordinates(){
            return coordinates;
        }
        public Integer getAnnualTurnover(){
            return annualTurnover;
        }
        public Long getEmployeesCount(){
            return employeesCount;
        }
        public OrganizationType getType(){
            return type;
        }
        public Address getPostalAddress(){
            return postalAddress;
        }
        @Override
        public String toString() {
            return "Data.Organization{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", coordinates=" + coordinates +
                    ", creationDate=" + creationDate +
                    ", annualTurnover=" + annualTurnover +
                    ", employeesCount=" + employeesCount +
                    ", type=" + type +
                    ", postalAddress=" + postalAddress +
                    '}';
        }

        public int compareTo(Organization organization){
            return id.compareTo(organization.getId());
        }


    }
