package users.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import users.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserId(long id);

}
