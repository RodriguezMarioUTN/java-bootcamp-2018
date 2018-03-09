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
@Table(name = "ITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    @JsonBackReference
    private Order pedido;

    @JsonIgnore
    public Order getPedido() {
        return pedido;
    }
    @JsonIgnore
    public void setPedido(Order pedido) {
        this.pedido = pedido;
    }
}
