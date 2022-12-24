package users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import users.entity.User;
import users.exceptions.OtherExceptions;
import users.helperFuncs.CalcAge;
import users.repo.UserRepo;

@Service  
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User addUser(User newUser) throws OtherExceptions {
		
		int age = new CalcAge().age(newUser.getDateofbirth());
		if (age >= 18)
			return userRepo.save(newUser);
		else
			throw new OtherExceptions("You must be at least 18 years of age");
	}

	@Override
	public User getUser(long id) throws OtherExceptions {
		User user = userRepo.findByUserId(id);
		
		if (user == null)
			throw new OtherExceptions("User not found with id "+id);
		else {
			user.setAge(new CalcAge().age(user.getDateofbirth()));
			return user;
		}
	}
	
	@Override
	public List<User> getUsers() {
		List<User> list =  userRepo.findAll();
		for (User user : list) {
			user.setAge(new CalcAge().age(user.getDateofbirth()));
		}
		return list;
	}

	@Override
	public void updateUser(User user, long id) {
		User getUser = userRepo.findById(id).get();		
		
		getUser.setDateofbirth(user.getDateofbirth());
		getUser.setEmail(user.getEmail());
		getUser.setFirstname(user.getFirstname());
		getUser.setLastname(user.getLastname());
		
		userRepo.save(getUser); 		
	}

	@Override
	public void deleteUser(long id) {
		userRepo.deleteById(id);
	}
	
}
