package retaurant.enums;

public enum OrderStatus {
    PENDING,
    DONE;

    public static OrderStatus getDefault() {
        return PENDING;
    }
}

