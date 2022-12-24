package users.controller;

import java.util.List;

import javax.validation.Valid;

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

import users.entity.User;
import users.exceptions.OtherExceptions;
import users.service.UserService;

@RestController 
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity <User> addUser (@RequestBody @Valid User newUser) throws OtherExceptions {
		return new ResponseEntity<>(userService.addUser(newUser), HttpStatus.CREATED);
	}
	
	@GetMapping 
	public ResponseEntity <List<User>> getUsers () {
		 return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <User> getUser (@PathVariable long id) throws OtherExceptions {
		 return ResponseEntity.ok().body(userService.getUser(id));
	}
	
	@PutMapping("/{id}")
	public void updateUser (@RequestBody @Valid User user, @PathVariable long id) {
		userService.updateUser(user, id);
	}
	
	@DeleteMapping ("/{id}")
	public void deleteUser (@PathVariable long id) {
		userService.deleteUser(id);
	}
}
