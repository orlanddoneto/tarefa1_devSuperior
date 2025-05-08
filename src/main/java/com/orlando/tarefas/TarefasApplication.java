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

		Integer codigo = sc.nextInt();

		Double valorBase = sc.nextDouble();

		Double desconto = sc.nextDouble();

		Order pedido = new Order(codigo,valorBase,desconto);

		System.out.println("Pedido Código: "+ pedido.getCode());
		Double valorFinal = orderService.total(pedido) + shippingService.shipment(pedido);

		System.out.println("Valor Total: R$"+valorFinal);
	}
}
