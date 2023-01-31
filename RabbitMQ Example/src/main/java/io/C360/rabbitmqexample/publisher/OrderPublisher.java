package io.C360.rabbitmqexample.publisher;

import io.C360.rabbitmqexample.DTO.Order;
import io.C360.rabbitmqexample.DTO.OrderStatus;
import io.C360.rabbitmqexample.config.MessageConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/order")
public class OrderPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName)
    {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus=new OrderStatus(order,"Process","Order Placed Successfully"+restaurantName);
        rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE,MessageConfig.ROUTING_KEY,orderStatus);
        return "SUCCESS !!!!";
    }

}
