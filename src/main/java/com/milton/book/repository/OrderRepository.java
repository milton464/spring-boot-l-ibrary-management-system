package com.milton.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.book.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findByuserid(long userid);
	Order findBybookname(String bookname);

	long countBybookname(String bookname);
}
