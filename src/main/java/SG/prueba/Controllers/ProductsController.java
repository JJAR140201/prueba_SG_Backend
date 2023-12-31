package SG.prueba.Controllers;
import SG.prueba.DTO.Products;
import SG.prueba.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Products>> listarTodos() {
        List<Products> productsList = productsService.listarTodos();
        return new ResponseEntity<>(productsList, HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Products> listarPorId(@PathVariable int id) {
        Products product = productsService.listarPorId(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(@RequestBody Products entidad) {
        productsService.registrar(entidad);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable int id, @RequestBody Products entidad) {
        Products existingProduct = productsService.listarPorId(id);
        if (existingProduct != null) {
            entidad.setId(id);
            productsService.actualizar(entidad);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        Products existingProduct = productsService.listarPorId(id);
        if (existingProduct != null) {
            productsService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}