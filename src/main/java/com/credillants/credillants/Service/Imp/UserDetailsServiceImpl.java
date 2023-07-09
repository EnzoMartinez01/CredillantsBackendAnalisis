package com.credillants.credillants.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.credillants.credillants.Entity.UsuariosEntity;
import com.credillants.credillants.Repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuariosRepository userRep;
	
	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		UsuariosEntity userload = userRep.findByUsername(username);
		if(userload == null) {
			throw new UsernameNotFoundException ("Usuario no encontrado");
		}
		return userload;
	}
}
