package S05T02N01F02GPedroTejero.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import S05T02N01F02GPedroTejero.model.domain.Jugador;
import S05T02N01F02GPedroTejero.model.dto.JugadaDTO;
import S05T02N01F02GPedroTejero.model.dto.JugadaMapper;
import S05T02N01F02GPedroTejero.model.dto.JugadorDTO;
import S05T02N01F02GPedroTejero.model.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {

	@Autowired
	JugadorRepository jugadorepository;

	@Transactional
		public void updateJugador(String jugador_id, JugadorDTO jugadordto) {
			jugadorepository.findById(jugador_id).get().setNombre(jugadordto.getNombre());
			
	}
	@Transactional
	public Optional<Jugador> updateJugadorJugada(String jugador_id, JugadaDTO jugadadto) {
		return jugadorepository.findById(jugador_id).map(target -> {
			target.getJugadas().add(JugadaMapper.toJugada(jugadadto));
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


	/*
	 * @Override public Optional<Jugador> updateJugador(String string, JugadorDTO
	 * jugadordto) { // TODO Auto-generated method stub return Optional.empty(); }
	 */
}
