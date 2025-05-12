package com.orlando.tarefas;

import com.orlando.tarefas.entities.Order;
import com.orlando.tarefas.services.OrderService;
import com.orlando.tarefas.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TarefasApplication  implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	@Autowired
	ShippingService shippingService;

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		SpringApplication.run(TarefasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order pedido1 = new Order(1034,150.0,20.0);
		System.out.println("Pedido Código: "+ pedido1.getCode());
		Double valorFinal = orderService.total(pedido1) + shippingService.shipment(pedido1);
		System.out.println("Valor Total: R$"+valorFinal);

		Order pedido2 = new Order(2282,800.0,10.0);
		System.out.println("Pedido Código: "+ pedido2.getCode());
		Double valorFinal2 = orderService.total(pedido2) + shippingService.shipment(pedido2);
		System.out.println("Valor Total: R$"+valorFinal2);

		Order pedido3 = new Order(1309,95.90,0.0);
		System.out.println("Pedido Código: "+ pedido3.getCode());
		Double valorFinal3 = orderService.total(pedido3) + shippingService.shipment(pedido3);
		System.out.println("Valor Total: R$"+valorFinal3);


	}
}
