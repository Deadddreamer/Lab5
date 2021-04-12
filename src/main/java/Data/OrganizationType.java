package Data;

public enum OrganizationType {
    COMMERCIAL,
    TRUST,
    PRIVATE_LIMITED_COMPANY,
    OPEN_JOINT_STOCK_COMPANY;

    public static String nameList() {
        String nameList = "";
        for (OrganizationType type : values()) {
            nameList += type.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}