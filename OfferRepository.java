package com.gl.mobileRechargeApplication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.mobileRechargeApplication.bean.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
	  @Query("select max(id) from Offer")
		public Long findMaxOfferId();
}
