package S05T02N01F02GPedroTejero.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S05T02N01F02GPedroTejero.model.domain.Jugada;
import S05T02N01F02GPedroTejero.model.domain.Jugador;
import S05T02N01F02GPedroTejero.model.dto.JugadaDTO;
import S05T02N01F02GPedroTejero.model.repository.JugadaRepository;
import S05T02N01F02GPedroTejero.model.repository.JugadorRepository;

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
	public Jugada getJugadabyId(String jugada_id) {
		return null;

		/*
		 * Optional<Jugada> jugada = jugadarepository.findById(jugada_id); if
		 * (jugada.isPresent()) { Jugada jugada1 = jugada.get(); return jugada1; } else
		 * return null;
		 */
	}

	@Override
	public List<Jugada> getAllJugadabyJugador(String jugador_id) {
		
	return jugadarepository.findAllByJugador_id(jugador_id);
	}

	@Override
	public void eliminarJugadas(String id) {

		/*
		 * Jugador jugador = jugadorepository.getReferenceById(jugador_id); for (int i =
		 * 0; i < jugador.getJugadas().size(); i++) { Jugada jugada =
		 * jugador.getJugadas().get(i); jugadarepository.delete(jugada);
		 */
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


