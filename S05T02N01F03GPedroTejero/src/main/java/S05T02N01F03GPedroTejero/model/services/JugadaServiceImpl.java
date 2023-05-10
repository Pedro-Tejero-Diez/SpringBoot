package S05T02N01F03GPedroTejero.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S05T02N01F03GPedroTejero.model.domain.Jugada;
import S05T02N01F03GPedroTejero.model.domain.Jugador;
import S05T02N01F03GPedroTejero.model.dto.JugadaDTO;
import S05T02N01F03GPedroTejero.model.repository.JugadaRepository;
import S05T02N01F03GPedroTejero.model.repository.JugadorRepository;

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
	public List<Jugada> getAllJugadabyJugador(String jugador_id) {

		return jugadarepository.findAllByJugador_id(jugador_id);
	}

	@Override
	public void eliminarJugadas(String jugador_id) {

		Optional<Jugador> jugador = jugadorepository.findById(jugador_id);

		if (jugador.isPresent()) {

			Jugador jugador1 = jugador.get();
			for (int i = 0; i < jugador1.getJugadas().size(); i++) {
				jugadarepository.delete(jugador1.getJugadas().get(i));
			}
		}

	}

	@Override
	public void guardarJugada(JugadaDTO jugadadto) {

		Jugador jugador = jugadorepository.findById(jugadadto.getJugador_id()).get();

		jugadarepository.save(new Jugada(jugadadto.getFechajug(), jugadadto.getUno(), jugadadto.getDos(), jugador));
	}

}

/*
 * Jugador jugador = jugadorepository.getReferenceById(jugador_id);
 * jugadorepository.getReferenceById(jugador_id).setJugadas(jugadas); if
 * (jugador.isPresent()) { List<Jugada> jugadas =null;
 * 
 * return true; } else return false;
 */
