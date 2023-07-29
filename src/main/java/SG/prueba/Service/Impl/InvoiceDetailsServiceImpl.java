package SG.prueba.Service.Impl;

import SG.prueba.DTO.InvoiceDetails;
import SG.prueba.Repository.InvoiceDetailsRepository;
import SG.prueba.Service.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository repo;
    @Override
    public List<InvoiceDetails> listarTodos() {
        return repo.findAll();
    }

    @Override
    public InvoiceDetails listarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void registrar(InvoiceDetails entidad) {
        repo.save(entidad);
    }

    @Override
    public void actualizar(InvoiceDetails entidad) {
        repo.save(entidad);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
