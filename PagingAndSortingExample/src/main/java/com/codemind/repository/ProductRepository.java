package com.codemind.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codemind.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//Page<Product> findAll(PageRequest of, Sort by);

}
