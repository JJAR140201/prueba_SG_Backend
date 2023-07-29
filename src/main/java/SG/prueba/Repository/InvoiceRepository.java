package SG.prueba.Repository;

import SG.prueba.DTO.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoices, Integer> {
}
