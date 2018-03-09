package com.shoppingcart.shoppingcartmario.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PAYMENT")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="PEDIDO_ID", foreignKey = @ForeignKey(name="Fk_Payment_Pedido"))
    private Order order;

    private Integer amount;

    @ManyToOne(cascade=CascadeType.ALL)
    @JsonBackReference
    private Client client;

    @JsonIgnore
    public Client getClient(){
        return this.client;
    }

    @JsonIgnore
    public void setClient(Client client) {
        this.client = client;
    }
}
