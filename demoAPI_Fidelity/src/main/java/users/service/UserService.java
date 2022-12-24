package users.service;

import java.util.List;

import users.entity.User;
import users.exceptions.OtherExceptions;

public interface UserService {
	User addUser (User newUser) throws OtherExceptions;
	User getUser (long id) throws OtherExceptions;
	List <User> getUsers();
	void updateUser(User user, long id);
	void deleteUser(long id);
}
