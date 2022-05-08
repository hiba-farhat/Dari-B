package tn.dari.spring.security;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.dari.spring.entity.User;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.service.UserService;

	@Component
	public class UserDetailsImpl implements UserDetails {
		
		private static final long serialVersionUID = 1L;
		User user;

		private Collection<? extends GrantedAuthority> authorities;

		public UserDetailsImpl(User user,
				Collection<? extends GrantedAuthority> authorities) {
			this.user = user;
			this.authorities = authorities;
		}
		
		public UserDetailsImpl() {
		}

		public static UserDetailsImpl build(User user) {
			List<GrantedAuthority> authorities = user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName().name()))
					.collect(Collectors.toList());

			return new UserDetailsImpl(user, 
					authorities);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}
		
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}
		
		public User getUser () throws Exception {
			return user;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			try {
				return user.isStateUser();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			UserDetailsImpl user1 = (UserDetailsImpl) o;
			return Objects.equals(user, user1);
		}

		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return user.getPassword();
		}
		
		

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return user.getUsername();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}
	}