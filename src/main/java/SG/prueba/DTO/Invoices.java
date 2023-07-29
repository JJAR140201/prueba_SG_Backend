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
    private int id;

    @Column(name = "nit")
    private String nit;

    @Column(name = "name")
    private String name;

    @Column(name = "subTotal")
    private float subTotal;

    @Column(name = "taxTotal")
    private float taxTotal;

    @Column(name = "totalDiscount")
    private float totalDiscount;

    @Column(name = "total")
    private float total;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime  deleted_at;

}
