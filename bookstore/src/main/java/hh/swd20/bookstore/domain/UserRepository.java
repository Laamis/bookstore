package hh.swd20.bookstore.domain;
import hh.swd20.bookstore.domain.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
}
