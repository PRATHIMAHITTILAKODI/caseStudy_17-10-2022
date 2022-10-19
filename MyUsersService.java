package com.gl.mobileRechargeApplication.authenticationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gl.mobileRechargeApplication.Dao.BillRepository;
import com.gl.mobileRechargeApplication.Dao.OfferRepository;
import com.gl.mobileRechargeApplication.Dao.UserRepository;
import com.gl.mobileRechargeApplication.bean.Bill;
import com.gl.mobileRechargeApplication.bean.MyUsers;
import com.gl.mobileRechargeApplication.bean.Offer;
@Service
public class MyUsersService implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private OfferRepository repository1;
	@Autowired
	private BillRepository repository2;

	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		
		return repository.findById(username).get();
	}
	public void save(MyUsers users) {
		repository.save(users);
	}
	//OFFER
	
	 public Long generateOfferId() {
			Long val=repository1.findMaxOfferId();
				 if(val==null)
					 val=1L;
				 else
					 val=val+1;
				 return val;
				 
			 }
	 public List<Offer> findAllOffers() {
			List<Offer> offerList = repository1.findAll();
			return offerList;
		}

		public Offer findAOffer(Long id) {
			Offer offer = repository1.getById(id);
			return offer;
		}
	 public void save(Offer offer ) {
			repository1.save(offer);
	 }
	 
	 //BILL SERVICE
	 public Long generateBillId() {
			Long val=repository2.findMaxTransactionId();
				 if(val==null)
					 val=100001L;
				 else
					 val=val+1;
				 return val;
				 
	 }
	 public void billSave(Bill bill) {
			repository2.save(bill);
		}
		
		
	
	
}