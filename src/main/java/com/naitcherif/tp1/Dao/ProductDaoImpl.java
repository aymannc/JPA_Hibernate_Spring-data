package com.naitcherif.tp1.Dao;

import com.naitcherif.tp1.Entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductDaoImpl implements InterfaceDao<Product> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product p) {
        entityManager.persist(p);
        return p;
    }

    @Override
    public List<Product> findAll() {
        Query q = entityManager.createQuery("select p from Product p");
        return q.getResultList();
    }

    @Override
    public Product findOne(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void remove(Long id) {
        Product p = findOne(id);
        entityManager.remove(p);
    }

    @Override
    public void update(Product p) {
        entityManager.merge(p);
    }

    @Override
    public List<Product> findByDesignation(String des) {
        Query q = entityManager.createQuery("select p from Product p where p.designation like :x");
        q.setParameter("x", "%" + des + "%");
        return q.getResultList();
    }
}
