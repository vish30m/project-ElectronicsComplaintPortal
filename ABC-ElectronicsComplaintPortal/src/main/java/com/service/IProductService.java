package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.exceptions.InValidModelNumberException;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;

@Service
@EnableJpaRepositories(basePackages="com.repository")
@Component
public class IProductService implements IProductService1
{	
	@Autowired
	IProductRepository repo;
	@Autowired
	IComplaintRepository com;
	@Autowired
	IEngineerRepository en;
	
	/*
	 * List <Product> list; public IProductService() { list=new ArrayList<>();
	 * list.add(new Product("Washing machine")); list.add(new Product("TV"));
	 * list.add(new Product("AC")); list.add(new Product("SmartPhone"));}
	 */
	
	@Override
	public Product addProduct(Product product) {
		repo.save(product);
		return product;
	}
	
	@Override
	public List<Product> getProduct() {
		List<Product> p=repo.findAll();
		return p;
	}

	@Override
	public String deleteProduct(Product product) {
		
		repo.delete(product);
		return "Deleted";
		
	}
	@Override
	public Product updateModelNumber(Product p) throws InValidModelNumberException {
		Product p1=repo.save(p);
		return p1;
	}
	
	public Product updateWarranty(Product p) throws InValidModelNumberException {
		
		Product p1=repo.save(p);
		return p1;
	}
	
	  @Override
	  public List<Complaint> getProductComplaints(String productCategoryName) {
		  List<Complaint> lc= ((IProductService) repo).getProductComplaints(productCategoryName); 
		  return lc; 
		  }
	@Override
	public List<Engineer> getEngineersByProduct(String productCategoryName) {
		 List<Engineer> lc= ((IProductService) repo). getEngineersByProduct(productCategoryName); 
		  return lc; 
		
	}

	

	
	 
	
	
	/*
	 * public Product addProduct(Product product) { repo.save(product); return
	 * product; } public String deleteProducts(Product category) {
	 * repo.delete(category); return "Deleted"; } public List<Product>
	 * getProduct(String categoryName) { List<Product> lc1=repo.findAll(); return
	 * lc1; } public Product updateProductWarranty(String modelNumber)throws
	 * InValidModelNumberException { Supplier s1= ()->new
	 * ResourceNotFoundException("Product Does not exist in the database"); Product
	 * product=repo.findById(modelNumber).orElseThrow(s1);
	 * product.setModelNumber(product.getModelNumber());
	 * product.setProductName(product.getProductName());
	 * product.setProductCategoryName(product.getProductCategoryName());
	 * repo.save(product); return product; } public Product
	 * getProductComplaints(String productCategoryName) { Product
	 * product=repo.findById(productCategoryName); return product; } public
	 * List<Engineer> getEngineersByProduct(String productCategoryName) {
	 * List<Engineer> lc2=eng.findById(employeeId); return lc2; }
	 */
	
	
	
}