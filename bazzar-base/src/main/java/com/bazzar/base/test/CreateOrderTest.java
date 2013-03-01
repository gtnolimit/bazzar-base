package com.bazzar.base.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bazzar.base.domain.Address;
import com.bazzar.base.domain.Email;
import com.bazzar.base.domain.Phone;
import com.bazzar.base.domain.customer.Customer;
import com.bazzar.base.domain.customer.Ip;
import com.bazzar.base.domain.lookup.AddressTypeLookup;
import com.bazzar.base.domain.lookup.EmailTypeLookup;
import com.bazzar.base.domain.lookup.OrderStatusLookup;
import com.bazzar.base.domain.lookup.PersonPrefixLookup;
import com.bazzar.base.domain.lookup.PhoneTypeLookup;
import com.bazzar.base.domain.lookup.StateTypeLookup;
import com.bazzar.base.domain.order.Cart;
import com.bazzar.base.domain.order.CartDetail;
import com.bazzar.base.domain.order.Order;
import com.bazzar.base.domain.order.OrderDetail;

public class CreateOrderTest {
	
	public CreateOrderTest () {}
	
	public Customer createCastomer ( String ip, String session ){
		Customer cust = new Customer ();
		cust.setActive(true);
		cust.setCPD(new Date ());
		cust.setUPD(new Date ());
		cust.setPersonPerfix(PersonPrefixLookup.MR);
		cust.setFirstName("John");
		cust.setLastName("Doe");
		//cust.setDob(new Date ("01/21/1999"));
		Set <Address> adds = new HashSet <Address> ();
		adds.add(this.setAddress (AddressTypeLookup.B, "12223 Maple St", "apt 545", 
				null, "Chicago", StateTypeLookup.IL, "60606", null, true  ));
		adds.add(this.setAddress (AddressTypeLookup.S, "12223 Maple St", "apt 545", 
				null, "Chicago", StateTypeLookup.IL, "60606", null, true  ));
		cust.setAddress(adds);
		
		Set <Phone> phone = new HashSet <Phone> ();
		phone.add(this.setPhone(PhoneTypeLookup.M, "1", "224", "555-5555", null, true));
		cust.setPhone(phone);
		
		Set <Email> email = new HashSet <Email> ();
		email.add(this.setEmail(EmailTypeLookup.P, "gtnolimit@yahoo.com", true));
		cust.setEmail(email);
		
		Set <Ip> ips = new HashSet <Ip> ();
		ips.add(this.setIp(session, ip));
		cust.setIp(ips);
		
		return cust;
	}
	public Order createOrder ( Cart cart ){
		Order order = new Order ();
		order.setActive(true);
		order.setCPD(new Date ());
		order.setUPD(new Date ());
		order.setInvoiceNumber("BAZZAR-" + String.format("%015d", cart.getId()));
		order.setIp ( cart.getIp ( ) );
		order.setSessionNumber ( cart.getSessionNumber ( ) );
		order.setOrderStatus ( OrderStatusLookup.CR );
		order.setDetail ( this.setOrderDetail ( cart.getDetail ( ) ) );
		order.setTotalBeforeTax ( cart.getShoppingCartSubTotal ( ) ); 
		return order;
	}
	private Ip setIp ( String session, String ip_t){
		Ip ip = new Ip ();
		ip.setCPD(new Date ());
		ip.setUPD(new Date ());
		ip.setSession(session);
		ip.setIps(ip_t);
		
		return ip;
	}
	private Phone setPhone (PhoneTypeLookup phoneType, String countryCode, String areaCode, String phone, String ext, boolean active){
		Phone ph = new Phone ();
		ph.setPhoneType(phoneType);
		ph.setCountryCode(countryCode);
		ph.setAreaCode(areaCode);
		ph.setPhone(phone);
		ph.setExt(ext);
		ph.setIsActive(active);
		ph.setUPD(new Date ());
		ph.setCPD(new Date ());

		return ph;
	}
	private Email setEmail (EmailTypeLookup emailType, String email, boolean active){
		Email e = new Email ();
		e.setEmailType(emailType);
		e.setEmail(email);
		e.setIsActive(active);
		e.setUPD(new Date ());
		e.setCPD(new Date ());
		return e;
	}
	private Address setAddress (AddressTypeLookup addressType, String addressLine1, 
			String addressLine2, String addressLine3, String city, StateTypeLookup stateType, 
			String zip, String zip4, boolean active){
		Address add = new Address ();
		add.setAddressType(addressType);
		add.setAddressLine1(addressLine1);
		add.setAddressLine2(addressLine2);
		add.setAddressLine3(addressLine3);
		add.setCity(city);
		add.setState(stateType);
		add.setZip(zip);
		add.setZip4(zip4);
		add.setIsActive(active);
		add.setUPD(new Date ());
		add.setCPD(new Date ());
		return add;
	}


	private Set <OrderDetail> setOrderDetail ( Set <CartDetail> carts ){
		Set <OrderDetail> ods = new HashSet <OrderDetail> ( );
		Iterator<CartDetail> it = carts.iterator ( );
		while ( it.hasNext ( ) ){
			CartDetail cd = (CartDetail) it.next ( );
			OrderDetail od = new OrderDetail ( );
			od.setCPD ( cd.getCPD ( ) );
			od.setUPD ( cd.getUPD ( ) );
			od.setItemId ( cd.getItemId ( ) );
			od.setPrice ( cd.getPrice ( ) );
			od.setQty ( cd.getQty ( ) );
			ods.add(od);
		}
		return ods;
	}
	
}
