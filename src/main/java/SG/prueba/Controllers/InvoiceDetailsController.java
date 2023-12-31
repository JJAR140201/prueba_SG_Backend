package SG.prueba.Controllers;

import SG.prueba.DTO.InvoiceDetails;
import SG.prueba.Service.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice-details")
public class InvoiceDetailsController {

    private final InvoiceDetailsService invoiceDetailsService;

    @Autowired
    public InvoiceDetailsController(InvoiceDetailsService invoiceDetailsService) {
        this.invoiceDetailsService = invoiceDetailsService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<InvoiceDetails>> listarTodos() {
        List<InvoiceDetails> invoiceDetailsList = invoiceDetailsService.listarTodos();
        return new ResponseEntity<>(invoiceDetailsList, HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<InvoiceDetails> listarPorId(@PathVariable int id) {
        InvoiceDetails invoiceDetails = invoiceDetailsService.listarPorId(id);
        if (invoiceDetails != null) {
            return new ResponseEntity<>(invoiceDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody InvoiceDetails entidad) {
        invoiceDetailsService.registrar(entidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody InvoiceDetails entidad) {
        InvoiceDetails existingInvoiceDetails = invoiceDetailsService.listarPorId(id);
        if (existingInvoiceDetails != null) {
            entidad.setId(id);
            invoiceDetailsService.actualizar(entidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int   id) {
        InvoiceDetails existingInvoiceDetails = invoiceDetailsService.listarPorId(id);
        if (existingInvoiceDetails != null) {
            invoiceDetailsService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
