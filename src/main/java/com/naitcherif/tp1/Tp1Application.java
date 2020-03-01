package com.naitcherif.tp1;

import com.naitcherif.tp1.Entity.Product;
import com.naitcherif.tp1.Repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Tp1Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Tp1Application.class, args);
        ProductRepository dao = ctx.getBean(ProductRepository.class);
        System.out.println("---------------------------------------------------------");
        System.out.println("Ajouter des Products");
        dao.save(new Product("AX 453", 870, 3));
        dao.save(new Product("TA 6753", 1230, 5));
        dao.save(new Product("HP 153", 340, 6));
        System.out.println("Consulter tous les Products");
        List<Product> prods = dao.findAll();
        for (Product p : prods) {
            System.out.println(p.getDesignation() + "----" + p.getPrice());
        }
        System.out.println("Consulter Un Product");
        if (dao.findById(4L).isPresent()) {
            Product p = dao.findById(4L).get();
            System.out.println("Product :" + p.getDesignation());
            System.out.println("Mettre à jour le Product 2");
            p.setDesignation("Epson A76500");
            dao.save(p);
        }

        System.out.println("Afficher les Products dont la désignation contient A ");
        List<Product> listProducts = dao.findByDesignation("%A%");

        if (listProducts != null) {
            for (Product pr : listProducts) {
                System.out.println(pr.getDesignation() + "----" + pr.getPrice());
            }
            System.out.println("Supprimer un Product");
            dao.delete(listProducts.get(listProducts.size() - 1));
        }
        System.out.println("Afficher tous les Products ");
        List<Product> listProducts2 = dao.findAll();
        for (Product pr : listProducts2) {
            System.out.println(pr.getDesignation() + "----" + pr.getPrice());
        }
    }

}
