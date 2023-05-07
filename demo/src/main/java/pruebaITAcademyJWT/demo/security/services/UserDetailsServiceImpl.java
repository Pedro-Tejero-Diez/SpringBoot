package pruebaITAcademyJWT.demo.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pruebaITAcademyJWT.demo.model.domain.Jugador;
import pruebaITAcademyJWT.demo.model.repository.JugadorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	JugadorRepository jugadorepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<Jugador> jugadores = jugadorepository.findAll();
		Jugador jugador = jugadores.get(0);
		int i = 0;
		boolean igual=false;
		while (!igual && i < jugadores.size()) {
			jugador = jugadores.get(i);
			if (jugadores.get(i).getNombre().equals(username)) {
			igual=true;
			}
			i++;
		}

		return UserDetailsImpl.build(jugador);
	}

}
