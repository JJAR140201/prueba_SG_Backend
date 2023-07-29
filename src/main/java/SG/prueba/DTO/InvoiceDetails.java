package SG.prueba.DTO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "invoicedetails")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idInvoice", nullable = false)
    private Invoices Invoices ;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Products Products ;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "discount")
    private float discount;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime  updated_at;

    @Column(name = "deleted_at")
    private LocalDateTime  deleted_at;
}
