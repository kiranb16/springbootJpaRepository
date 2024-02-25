package com.codemind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemind.dto.ApiResponce;
import com.codemind.model.Product;
import com.codemind.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping()
	private ApiResponce<List<Product>> getProduct() {
		List<Product> allProduct = productService.findAllProducts();
		return new ApiResponce<List<Product>>(allProduct.size(), allProduct);
	}

	@GetMapping("/{field}")
	private ApiResponce<List<Product>> getProductWithSortig(@PathVariable String field) {
		List<Product> allProduct = productService.findProductWithSorting(field);
		return new ApiResponce<List<Product>>(allProduct.size(), allProduct);
	}

	@GetMapping("pagination/{ofset}/{pageSize}")
	private ApiResponce<Page<Product>> getProductWithPagination(@PathVariable int ofset, @PathVariable int pageSize) {
		Page<Product> allProduct = productService.findProductByPaginationAndSorting(ofset, pageSize);
		return new ApiResponce<Page<Product>>(allProduct.getSize(), allProduct);
	}

	@GetMapping("paginationAndSorting/{ofset}/{pageSize}/{field}")
	private ApiResponce<Page<Product>> getProductWithPaginationAndSort(@PathVariable int ofset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<Product> allProduct = productService.findProductByPaginationAndSortingField(ofset, pageSize,field);
		return new ApiResponce<Page<Product>>(allProduct.getSize(), allProduct);
	}
}
