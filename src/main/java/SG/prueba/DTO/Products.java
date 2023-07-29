package SG.prueba.DTO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", nullable = true, length = 12)
    private String code;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "price", nullable = true)
    private float price;

    @Column(name = "stock", nullable = true)
    private int stock;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime  deleted_at;
}
