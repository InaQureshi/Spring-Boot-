package io.C360.rabbitmqexample.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatus {

    private Order order;

    private String status;

    private String message;
}
