//IProductRepo.java
package com.nt.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.prod.Product;

public interface IProductRepo extends JpaRepository<Product,Integer> {

}
