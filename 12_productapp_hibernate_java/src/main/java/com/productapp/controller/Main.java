package com.productapp.controller;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.config.AppConfig;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;
public class Main {
	public static void main(String[] args) {

	
		
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(AppConfig.class);
		

		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		
		
		 List<Product> productList=productService.getAll();
		 
		 productList.forEach(p-> System.out.println(p));
		 
		Product product=new Product(6,"pen", new BigDecimal(33), true);
		
		productService.addProduct(product);
	
		product=productService.getById(2);
		product.setAvailable(true);
		productService.updateProduct(2, product);
	}

}
