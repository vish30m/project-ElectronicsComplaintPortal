
  package com.service;
  
  import java.util.List;

import com.entities.Complaint; 
import com.entities.Engineer;
import com.entities.Product;
import com.exceptions.InValidModelNumberException;
  
  public interface IProductService1 {
  
  public Product addProduct(Product product);
  public String deleteProduct(Product product ); 
  public List<Product> getProduct();
  
  public Product updateModelNumber(Product p)throws InValidModelNumberException;
  
  public List<Complaint> getProductComplaints(String productCategoryName);
  public List<Engineer> getEngineersByProduct(String productCategoryName);

  
  
  
  }
 
