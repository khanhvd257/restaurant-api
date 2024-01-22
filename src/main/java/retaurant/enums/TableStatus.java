package retaurant.enums;

public enum TableStatus {
    FREE,
    RESERVED,
    USING;

    public static TableStatus getDefault() {
        return FREE;
    }

}
