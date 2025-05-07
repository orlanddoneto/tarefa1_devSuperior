package com.orlando.tarefas.services;

import com.orlando.tarefas.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Double total(Order order){
        return order.getBasicValue() * (1-(order.getDiscount()/100));
    }
}
