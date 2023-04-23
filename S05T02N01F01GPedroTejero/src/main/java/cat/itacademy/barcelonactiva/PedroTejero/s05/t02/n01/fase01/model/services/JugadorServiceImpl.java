package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository.JugadorRepository;
import jakarta.transaction.Transactional;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	JugadorRepository jugadorepository;

	@Transactional
	public Optional<Jugador> updateJugador(int jugador_id, JugadorDTO jugadordto) {
		return jugadorepository.findById(jugador_id).map(target -> {
			target.setNombre(jugadordto.getNombre());
			return target;
		});
	}

	@Override
	public List<Jugador> getAllJugador() {
		return jugadorepository.findAll();
	}

	@Override
	public void guardarJugador(Jugador jugador) {
		jugadorepository.save(new Jugador(jugador.getFechareg(), jugador.getNombre(), jugador.getPwd()));

	}

	@Override
	public Jugador getJugadorbyId(int jugador_id) {

		Optional<Jugador> jugador = jugadorepository.findById(jugador_id);
		if (jugador.isPresent()) {
			Jugador jugador1 = jugador.get();
			return jugador1;
		} else
			return null;

	}

	@Override
	public boolean deleteJugador(int jugador_id) {

		Optional<Jugador> jugador = jugadorepository.findById(jugador_id);
		if (jugador.isPresent()) {
			jugadorepository.deleteById(jugador_id);
			return true;
		} else
			return false;

	}
}
