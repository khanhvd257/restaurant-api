package retaurant.entity;

import jakarta.persistence.*;
import lombok.Data;
import retaurant.enums.ReservationStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
public class Reservation extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;
    @Column(name = "number_of_people")
    private int numberOfPeople;
    private int tableId;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status = ReservationStatus.getDefault();


}
