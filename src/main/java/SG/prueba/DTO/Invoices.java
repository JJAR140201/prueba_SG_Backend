package SG.prueba.DTO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "invoices")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Invoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nit", nullable = true)
    private String nit;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "subTotal", nullable = true)
    private float subTotal;

    @Column(name = "taxTotal", nullable = true)
    private float taxTotal;

    @Column(name = "totalDiscount", nullable = true)
    private float totalDiscount;

    @Column(name = "total", nullable = true)
    private float total;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime created_at;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime  deleted_at;

}
