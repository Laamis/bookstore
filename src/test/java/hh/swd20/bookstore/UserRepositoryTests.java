package hh.swd20.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	@Autowired
	private UserRepository uRepo;
	
	@Test
	public void CreateUserTest() {
		User user = new User("user","user", "user@mail.com","user");
		uRepo.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void findByUsernameReturnUser() {
	User user = new User("user","user", "user@mail.com","user");
	uRepo.save(user);
	assertThat(uRepo.findByUsername("user")).isNotNull();
	}
	
	@Test
	public void deleteUserTest() {
	User user = new User("user","user", "user@mail.com","user");
	uRepo.save(user);
	//tests whether the user is saved to the repo
	assertThat(uRepo.findByUsername("user")).isEqualTo(user);
	
	uRepo.delete(user);
	assertThat(uRepo.findByUsername("user")).isNull();
	

	}
}
