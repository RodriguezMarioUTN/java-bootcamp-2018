package com.shoppingcart.shoppingcartmario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="CLIENT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String description;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(foreignKey = @ForeignKey(name="Fk_Client_Payment"), name = "CLIENT_ID")
    @JsonManagedReference
    private List<Payment> payments;

    @JsonIgnore
    public List<Payment> getPayments() {
        return payments;
    }
    @JsonIgnore
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
