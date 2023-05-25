package S05T02N01F03GPedroTejero.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import S05T02N01F03GPedroTejero.model.domain.Jugador;
import S05T02N01F03GPedroTejero.model.repository.JugadorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	JugadorRepository jugadorepository;

	@Override
	@Transactional
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {

		List<Jugador> jugadores = jugadorepository.findAll();
		Jugador jugador = jugadores.get(0);
		int i = 0;
		boolean igual = false;
		while (!igual && i < jugadores.size()) {
			jugador = jugadores.get(i);
			if (jugadores.get(i).getNombre().equals(username)) {
				igual = true;
			}
			i++;
		}

		return UserDetailsImpl.build(jugador);
	}

}
