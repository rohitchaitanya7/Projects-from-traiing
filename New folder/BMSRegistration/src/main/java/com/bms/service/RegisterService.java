package com.bms.service;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bms.exception.InitialDepositException;
import com.bms.exception.InvalidTokenException;
import com.bms.exception.UnauthorizedException;
import com.bms.exception.UserExistsException;
import com.bms.exception.UserNotFoundException;
import com.bms.model.Customer;
import com.bms.model.ResponseForSuccess;
@Service
public interface RegisterService {
	public ResponseEntity<ResponseForSuccess> register(Customer customer) throws InitialDepositException,UserExistsException;
	public ResponseEntity<ResponseForSuccess> editDetails(String token,Customer customer,String cid) throws UnauthorizedException,InvalidTokenException;
	public ResponseEntity<Object> getCustomerDetails(String customer_id) throws UserNotFoundException;
	public ResponseEntity<Object> deleteCustomerDetails(String customer_id) throws UserNotFoundException;
}
