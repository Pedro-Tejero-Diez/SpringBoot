package com.ITAcademy.demoJWTSQL.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ITAcademy.demoJWTSQL.domain.models.Jugador;
import com.ITAcademy.demoJWTSQL.domain.repositories.JugadorRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	JugadorRepository jugadorepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Jugador jugador = jugadorepository.findByNombre(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(jugador);
	}

}
