package com.springboot.springbootfirstapp.sevice;

import java.util.List;
//import java.util.Random;
//import java.util.stream.IntStream;
//import java.util.stream.Collectors;
//
//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.springboot.springbootfirstapp.entity.Product;
import com.springboot.springbootfirstapp.repository.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
//	@PostConstruct
//	public void initDB() {
//		List<Product> products = IntStream.rangeClosed(1, 200)
//              .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//              .collect(Collectors.toList());
//      repository.saveAll(products);
//	}
	
	//POST Method
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	//GET method
	public List<Product> getProducts()
	{
		return repository.findAll();
	}
	
	public Product getProductById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name)
	{
		return repository.findByName(name);
	}
	
	//Pagination
	public Page<Product> findProductsWithPagination(int offset,int pageSize){
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }
	
	
	//DELETE method
	public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }
	
	//UPDATE method
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
