package com.example.components.services;

import org.springframework.stereotype.Service;

import com.example.components.entities.Order;

@Service
public class OrderService {

	private ShippingService shipmentService;

	public OrderService(ShippingService shipmentService) {
		super();
		this.shipmentService = shipmentService;
	}
	
	public ShippingService getShipmentService() {
		return shipmentService;
	}

	public void setShipmentService(ShippingService shipmentService) {
		this.shipmentService = shipmentService;
	}
	
	public double total(Order order) {
		return order.getBasic() - (order.getBasic() * order.getDiscount()/100)
				+ shipmentService.shipment(order);  
	}
}
