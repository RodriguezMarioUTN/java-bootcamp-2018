package com.shoppingcart.shoppingcartmario.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "PEDIDO")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="ITEM_ID", foreignKey = @ForeignKey(name="Fk_Pedido_Item"))
    private List<Item> items;
}
