package com.example.finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalproject.Payload.UserPayload;
import com.example.finalproject.business.UserBusiness;
import com.example.finalproject.exception.BaseException;
import com.example.finalproject.json.UserListJson;
import com.example.finalproject.login.LoginRequest;
import com.example.finalproject.login.LoginResponse;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.UserRepositiry;
import com.example.finalproject.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userservice;
	@Autowired
	UserRepositiry userrepository;
	@Autowired
	UserBusiness userbusiness;

	UserPayload userpayload;
	
    @GetMapping
    public ResponseEntity<List<UserListJson>> getAllUsers() throws BaseException{
        return ResponseEntity.ok(userbusiness.getListuser());
    }
    @GetMapping("/{id}")///
	public ResponseEntity<UserListJson> getUserById(@PathVariable("id")long id) throws BaseException{
		return ResponseEntity.ok(userbusiness.getUserId(id));
	}
	
	@PutMapping("all/{id}") ///
	public ResponseEntity<UserListJson> updateUser(@PathVariable("id")long id,
			@RequestBody UserPayload payload){
		
		Optional<User> userdata = userservice.findOptionalById(id);
		if(userdata.isPresent()) {
			userbusiness.updateUser(userdata.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

	}
	@PutMapping("/{id}") ///
	public ResponseEntity<UserListJson> updateprofile(@PathVariable("id")long id,
			@RequestBody UserPayload payload){
		
		Optional<User> userdata = userservice.findOptionalById(id);
		if(userdata.isPresent()) {
			userbusiness.updateProfile(id, payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

	}
	
	@DeleteMapping("/{id}") ///
	public ResponseEntity<HttpStatus> deleteuser(@PathVariable("id") long id){
		try {
			userbusiness.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserPayload payload) throws BaseException{
    	
    	User existingUser = userservice.findByEmail(payload.getEmail());
    	
        if (existingUser != null) {
    
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } 
        
        else {

            User newUser = new User();
            
            newUser.setEmail(payload.getEmail());
            newUser.setPassword(payload.getPassword());
            newUser.setUsername(payload.getUsername());
            
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            String hashedPassword = passwordEncoder.encode(payload.getPassword());
//            newUser.setPassword(hashedPassword);

            userservice.save(newUser);

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest requestLogin) {
		
		String email = requestLogin.getEmail();
		String password = requestLogin.getPassword();

		User userdata = userservice.loginUser(email, password);
		
		if (userdata != null) {
			return new ResponseEntity<>(userdata, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>("login error", HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	

    

	
 
	

}
