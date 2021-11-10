//IOffersRepo.java
package com.nt.repo.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.promotions.Offers;

public interface IOffersRepo extends JpaRepository<Offers, Integer> {

}
