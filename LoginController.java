package com.gl.mobileRechargeApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.mobileRechargeApplication.authenticationService.MyUsersService;
import com.gl.mobileRechargeApplication.bean.Bill;
import com.gl.mobileRechargeApplication.bean.Offer;

@RestController
public class LoginController {
	
	 @Autowired
		private MyUsersService service;
	 
	
		
		@GetMapping(value="/loginpage")
		 public ModelAndView showLoginPage() {
			 return new ModelAndView("loginPage");
		 }
		@GetMapping(value="/loginerror")
		 public ModelAndView showErrorPage() {
			 return new ModelAndView("errorPage");	
		}
	/*  @GetMapping(value="/index")
	  public ModelAndView showIndexPage() {
		  ModelAndView mv= new ModelAndView("index");
		  List<Offer> offerList=service.findAllOffers();
			mv.addObject("offerList",offerList);
			return mv;
	  }*/
	  @GetMapping("index")
		public ModelAndView showIndex() {
			ModelAndView mv = new ModelAndView("index");
			List<Offer> offerList = service.findAllOffers();
			mv.addObject("offerList",offerList);
			return mv;
		}
	 /*@GetMapping(value="/index/{id}")
	  @GetMapping(value ="/performRecharge")
		public ModelAndView showABill(@PathVariable long id) {
			Bill  bill=service.findABill(id);
			 ModelAndView mv =  new ModelAndView("performRecharge");
		     mv.addObject("bill",bill);
		     return mv;
		}
	  @PostMapping(value="/offer")
		public ModelAndView saveNewCompany(@ModelAttribute("offerRecord")Offer offer) {
			long id=service.generateOfferId();
			offer.setId(id);
			service.save(offer);
			return new ModelAndView("redirect:/index");
		}
	    @GetMapping(value="/offer")
	  public ModelAndView showCompanyEntryPage() {
		  Offer offer=new Offer();
		  ModelAndView mv=new ModelAndView("offerEntry");
		  mv.addObject("offerRecord",offer);
		  return mv;
	  }
	
	/*	@GetMapping(value="/welcome")
		public ModelAndView showWelcomePage() {
			return new ModelAndView("welcome");
		}
		@PostMapping("performRecharge/{transactionId}")
			public ModelAndView saveNewBill(@ModelAttribute("offerRecord")Offer offer) {
				long id=service.generateOfferId();
				offer.setId(id);
				service.save(offer);
				return new ModelAndView("redirect:/index");
			}*/
	    @GetMapping(value="/performRecharge")
		public ModelAndView showBill(@RequestParam("mobileNum") String mobileNum, @RequestParam("radio") Long id) {
			ModelAndView mv = new ModelAndView("performRecharge");
			Offer resOffer = service.findAOffer(id);
			Long transactionId = service.generateBillId();
			mv.addObject("resOffer", resOffer);
			mv.addObject("mobileNum", mobileNum);
			mv.addObject("transactionId", transactionId);
			
			Bill bill = new Bill();
			bill.setMobileNumber(Integer.parseInt(mobileNum));
			bill.setOfferId(id);
			bill.setTransactionId(transactionId);
			
			service.billSave(bill);
			return mv;
		}
}
