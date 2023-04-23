package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto.JugadaDTO;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository.JugadaRepository;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.repository.JugadorRepository;

@Service
public class JugadaServiceImpl implements JugadaService {

	@Autowired
	JugadaRepository jugadarepository;
	@Autowired
	JugadorRepository jugadorepository;

	@Override
	public List<Jugada> getAllJugada() {

		return jugadarepository.findAll();
	}

	@Override
	public void guardarJugada(JugadaDTO jugadadto) {

		Jugador jugador = jugadorepository.getReferenceById(jugadadto.getJugador_id());

		jugadarepository.save(new Jugada(jugadadto.getFechajug(), jugadadto.getUno(), jugadadto.getDos(), jugador));
	}

	@Override
	public Jugada getJugadabyId(int jugada_id) {

		Optional<Jugada> jugada = jugadarepository.findById(jugada_id);
		if (jugada.isPresent()) {
			Jugada jugada1 = jugada.get();
			return jugada1;
		} else
			return null;
	}

	@Override
	public List<Jugada> getAllJugadabyJugador(int jugador_id) {
		return jugadarepository.findByJugadorId(jugador_id);
	}

	@Override
	public void eliminarJugadas(int jugador_id) {

		Jugador jugador = jugadorepository.getReferenceById(jugador_id);
		for (int i = 0; i < jugador.getJugadas().size(); i++) {
			Jugada jugada = jugador.getJugadas().get(i);
			jugadarepository.delete(jugada);
		}

		/*
		 * Jugador jugador = jugadorepository.getReferenceById(jugador_id);
		 * jugadorepository.getReferenceById(jugador_id).setJugadas(jugadas); if
		 * (jugador.isPresent()) { List<Jugada> jugadas =null;
		 * 
		 * return true; } else return false;
		 */

	}

}
