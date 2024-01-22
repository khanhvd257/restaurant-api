package retaurant.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Category extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "parent_id")
    private Long parentId;


}
