package io.C360.rabbitmqexample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

    private String orderId;

    private String name;

    private int qty;

    private Long price;
}
