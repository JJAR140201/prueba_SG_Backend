package SG.prueba.Controllers;
import SG.prueba.DTO.Invoices;
import SG.prueba.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public ResponseEntity<List<Invoices>> listarTodos() {
        List<Invoices> invoicesList = invoiceService.listarTodos();
        return new ResponseEntity<>(invoicesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoices> listarPorId(@PathVariable int id) {
        Invoices invoices = invoiceService.listarPorId(id);
        if (invoices != null) {
            return new ResponseEntity<>(invoices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Invoices entidad) {
        invoiceService.registrar(entidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody Invoices entidad) {
        Invoices existingInvoice = invoiceService.listarPorId(id);
        if (existingInvoice != null) {
            entidad.setId(id);
            invoiceService.actualizar(entidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        Invoices existingInvoice = invoiceService.listarPorId(id);
        if (existingInvoice != null) {
            invoiceService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}