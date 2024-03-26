package com.example.components;

import java.io.Serial;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.components.entities.Order;
import com.example.components.services.OrderService;
import com.example.components.services.ShippingService;

@SpringBootApplication
@ComponentScan({"com.example.components"})
public class ComponentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentsApplication.class, args);
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		//System.out.print("Entre com os dados do pedido:\n"
		//		+ "código: ");
		Integer code = sc.nextInt();
		//System.out.print("valor básico: ");
		double basic = sc.nextDouble();
		//System.out.print("porcentagem de disconto: ");
		double discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		ShippingService shippingService = new ShippingService();
		
		OrderService orderService = new OrderService(shippingService);
		
		System.out.printf("Pedido código %d \n"
				+ "Valor total: %.2f \n", order.getCode(), orderService.total(order));
	}

}
