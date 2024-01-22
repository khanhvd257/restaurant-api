package retaurant.enums;

public enum ReservationStatus {
    PENDING,
    CONFIRMED,
    CANCELED,
    REJECT,
    DONE;
    public static ReservationStatus getDefault() {
        return PENDING;
    }
}
