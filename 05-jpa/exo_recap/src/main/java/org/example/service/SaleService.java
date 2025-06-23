package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.Sale;
import org.example.entity.SaleLine;
import org.example.enums.SaleStatus;
import org.example.repository.SaleDAO;
import org.example.repository.SaleLineDAO;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.List;

public class SaleService {
    private SaleDAO saleDAO;
    private SaleLineDAO saleLineDAO;

    public SaleService() {
        saleDAO = new SaleDAO();
        saleLineDAO = new SaleLineDAO();
    }

    public Sale getById(int id) throws EntityNotFoundException { return saleDAO.get(id); }

    public List<Sale> getAll() { return saleDAO.get(); }

    public List<Sale> getBySatus(SaleStatus status) { return saleDAO.getByStatus(status); }

    public List<Sale> getByDates(Date start, Date end) { return saleDAO.getByDates(start, end); }

    public Sale createSale(Date date, SaleStatus status, Customer customer, List<SaleLine> saleLines) {
        double total = 0.0;
        for (SaleLine saleLine : saleLines) { total += saleLine.getTotalPrice(); }

        Sale sale = Sale.builder().total(total).saleDate(date).status(status).customer(customer).build();
        saleDAO.save(sale);

        return sale;
    }

    public SaleLine createSaleLine(int quantity, Product product, Sale sale) {
        double total = product.getPrice() * quantity;

        SaleLine saleLine = SaleLine.builder().productQuantity(quantity).product(product).totalPrice(total).sale(sale).build();
        saleLineDAO.save(saleLine);

        return saleLine;
    }

    public void changeStatus(Sale sale, SaleStatus newStatus){ saleDAO.changeStatus(sale, newStatus); }

}
