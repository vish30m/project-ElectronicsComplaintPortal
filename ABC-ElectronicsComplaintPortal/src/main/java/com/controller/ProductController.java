package com.controller;
 import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.http.HttpStatus; 
  import org.springframework.http.ResponseEntity; 
  import org.springframework.web.bind.annotation.DeleteMapping;
  import org.springframework.web.bind.annotation.GetMapping; 
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.PutMapping;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping; 
  import org.springframework.web.bind.annotation.RestController;
import com.entities.Engineer;
  import com.entities.Product;
  import com.service.IProductService;
  
  @RestController
  
  @RequestMapping(path="/api") 
  public class ProductController {
   
  @Autowired
  IProductService productservice;
 
  @PostMapping("/addProduct")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	  Product p1=productservice.addProduct(product);
	  ResponseEntity<Product> re=new ResponseEntity<Product>(p1,HttpStatus.OK);
	  return re; 
	  }
  
  @DeleteMapping(path="/deleteProduct") 
  public ResponseEntity<String>deleteProduct(@RequestBody Product e) {
	  productservice.deleteProduct(e);
      ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK); 
      return re; 
      }
  
  @GetMapping("/getProducts") 
  public ResponseEntity<Product> getProduct(){
	  List<Product> lc1=productservice.getProduct();
		ResponseEntity re=new ResponseEntity<List<Product>>(lc1,HttpStatus.OK);
		return re;
  }
  
  @PostMapping(path="/updateProductWarranty") 
  public ResponseEntity<Product>updateProduct(Product p) throws Throwable {
	 Product e1=productservice.updateWarranty(p);
     ResponseEntity re=new ResponseEntity<Product>(e1,HttpStatus.OK); 
     return re;
  }
  
	
	
	  @GetMapping("/getProductComplaints") public
	  ResponseEntity<Product>getProductComplaints(@PathVariable String
	  productCategoryName) { Product p=(Product)
	  productservice.getProductComplaints(productCategoryName); ResponseEntity
	  re=new ResponseEntity<Product>(p,HttpStatus.OK); 
	  return re;
	  }
	 
	
	  @GetMapping("/getEngineersByProduct") public ResponseEntity<List<Engineer>>
	  getEngineersByProduct(@PathVariable String productCategoryName) {
	  List<Engineer> lc=productservice.getEngineersByProduct(productCategoryName);
	  ResponseEntity re=new ResponseEntity<List<Engineer>>(HttpStatus.OK); return
	  re; }
	 
	  }
 