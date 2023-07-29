package SG.prueba.Service.Impl;

import SG.prueba.DTO.Invoices;
import SG.prueba.Repository.InvoiceRepository;
import SG.prueba.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repo;
    @Override
    public List<Invoices> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Invoices listarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void registrar(Invoices entidad) {
        repo.save(entidad);
    }

    @Override
    public void actualizar(Invoices entidad) {
        repo.save(entidad);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
