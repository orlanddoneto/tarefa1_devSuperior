package com.orlando.tarefas.services;

import com.orlando.tarefas.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public Double shipment(Order order){
        if (order.getBasicValue()<100)
            return 20.0;
        else if (order.getBasicValue()>= 100 && order.getBasicValue()<200)
            return 12.0;
        else
            return 0.0;
    }
}
