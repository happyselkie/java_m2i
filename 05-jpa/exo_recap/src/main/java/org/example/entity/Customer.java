package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;

    private String name;
    private String address;
    private String email;
    private boolean active;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    @Override
    public String toString() {
        String status = "actif";
        if (!active) {status = "inactif";}

        return "Client (id:" +idCustomer+") :\n"+
                "Nom :'" + name + "\n" +
                "Adresse :" + address + "\n" +
                "Email :" + email + "\n" +
                "Statut : " + status;
    }
}
