package com.milton.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milton.book.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long>{

}
