package com.gl.mobileRechargeApplication.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.mobileRechargeApplication.bean.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	  @Query("select max(transactionId) from Bill")
			public Long findMaxTransactionId();
}
