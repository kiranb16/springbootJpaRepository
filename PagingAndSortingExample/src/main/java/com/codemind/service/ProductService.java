package com.codemind.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.codemind.model.Product;
import com.codemind.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

//	@PostConstruct
//	public void initDb() {
//		 List<Product> products= IntStream.rangeClosed(1, 200)
//				 .mapToObj(i -> new Product( i, "product"+i, new Random().nextInt(100), new Random().nextInt(100)) )
//				 .collect(Collectors.toList());
//		 productRepository.saveAll(products);
//	}
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public List<Product> findProductWithSorting(String field) {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public org.springframework.data.domain.Page<Product> findProductByPaginationAndSorting(int ofset, int pageSize) {
		org.springframework.data.domain.Page<Product> products = productRepository
				.findAll(PageRequest.of(ofset, pageSize));

		return products;
	}

	public org.springframework.data.domain.Page<Product> findProductByPaginationAndSortingField(int ofset, int pageSize,
			String field) {
		// TODO Auto-generated method stub
		return productRepository.findAll(PageRequest.of(ofset, pageSize),Sort.by(Direction.ASC,field));
	}
}
