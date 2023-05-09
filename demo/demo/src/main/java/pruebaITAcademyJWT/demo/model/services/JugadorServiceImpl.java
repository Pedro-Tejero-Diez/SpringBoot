package pruebaITAcademyJWT.demo.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pruebaITAcademyJWT.demo.model.domain.Jugador;
import pruebaITAcademyJWT.demo.model.dto.JugadorDTO;
import pruebaITAcademyJWT.demo.model.repository.JugadorRepository;


@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	JugadorRepository jugadorepository;

	@Transactional
		public void updateJugador(String jugador_id, JugadorDTO jugadordto) {
		
			Jugador jugador = jugadorepository.findById(jugador_id).get();
			jugador.setNombre(jugadordto.getNombre());
			jugadorepository.save(jugador);
			
	}


	@Override
	public List<Jugador> getAllJugador() {
		return jugadorepository.findAll();
	}

	@Override
	public void guardarJugador(Jugador jugador) {
		jugadorepository.save(new Jugador(jugador.getFechareg(), 
				jugador.getNombre(), jugador.getPwd(), jugador.getRoles()));

	}

	@Override
	public Jugador getJugadorbyId(String jugador_id) {

		Optional<Jugador> jugador = jugadorepository.findById(jugador_id);
		if (jugador.isPresent()) {
			Jugador jugador1 = jugador.get();
			return jugador1;
		} else
			return null;

	}

	@Override
	public boolean deleteJugador(String jugador_id) {

		Optional<Jugador> jugador = jugadorepository.findById(jugador_id);
		if (jugador.isPresent()) {
			jugadorepository.deleteById(jugador_id);
			return true;
		} else
			return false;

	}

}
