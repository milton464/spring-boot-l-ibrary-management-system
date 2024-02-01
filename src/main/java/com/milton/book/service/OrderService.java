package com.milton.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milton.book.model.Order;
import com.milton.book.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order>listOrder(){
		return orderRepository.findAll();
	}

public Order findByuserid(long userid) {
	return orderRepository.findByuserid(userid);
}

public void saveOrder(Order order) {
	orderRepository.save(order);
}

public Order findBybookname(String bookname) {
	return orderRepository.findBybookname(bookname);
}

public long countBybookname(String bookname) {

	return orderRepository.countBybookname(bookname);
}



}
