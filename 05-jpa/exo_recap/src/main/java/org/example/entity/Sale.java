package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.enums.SaleStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSale;

    private double total;
    private Date saleDate;

    private SaleStatus status;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idCustomer")
    private Customer customer;

    @OneToMany(mappedBy = "sale")
    private List<SaleLine> saleLines;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (SaleLine line : saleLines) {
            sb.append(line).append("\n   - ");
        }

        return "---- Vente id:"+idSale+" ----\n"+
                "Total de la vente :" + total +"\n"+
                "Date de la vente :" + saleDate.toLocalDate().toString() + "\n"+
                "Satut : " + status.toString().toLowerCase() + "\n"+
                "Client : " + customer.getName() + " (" + customer.getEmail()+ ") \n"+
                "Produits  :\n" +
                "   - "+ sb;
    }
}
