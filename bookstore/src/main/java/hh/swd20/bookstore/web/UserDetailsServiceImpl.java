package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.bookstore.domain.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	@Autowired
	public UserDetailsServiceImpl(UserRepository uRepo) {
		this.repository = uRepo; 
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		hh.swd20.bookstore.domain.User curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
	}
}
