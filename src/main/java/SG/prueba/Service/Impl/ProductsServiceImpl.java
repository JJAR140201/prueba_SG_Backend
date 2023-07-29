package SG.prueba.Service.Impl;

import SG.prueba.DTO.Products;
import SG.prueba.Repository.ProductsRepository;
import SG.prueba.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository repo;

    @Override
    public List<Products> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Products listarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void registrar(Products entidad) {
        repo.save(entidad);
    }

    @Override
    public void actualizar(Products entidad) {
        repo.save(entidad);
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
}
