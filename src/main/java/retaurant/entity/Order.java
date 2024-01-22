package retaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import retaurant.enums.OrderStatus;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "table_date")
    private Long tableId;
    @Column(name = "total_price")
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.getDefault();


}
