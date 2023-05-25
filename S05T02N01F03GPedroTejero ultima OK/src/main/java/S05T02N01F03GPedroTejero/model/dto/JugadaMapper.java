package S05T02N01F03GPedroTejero.model.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import S05T02N01F03GPedroTejero.model.domain.Jugada;
import S05T02N01F03GPedroTejero.model.repository.JugadorRepository;

@Component
public class JugadaMapper {

	@Autowired
	static JugadorRepository jugadorepo;

	public static JugadaDTO toJugadaDTO(Jugada jugada) {
		String jugador_id = jugada.getJugador().get_id();
		LocalDate fechajug = jugada.getFechajug();
		byte uno = jugada.getUno();
		byte dos = jugada.getDos();

		return new JugadaDTO(jugador_id, fechajug, uno, dos);
	}

	public static Jugada toJugada(JugadaDTO jugadadto) {

		// Jugador jugador = jugadorepo.findById(jugadadto.getJugador_id()).get();

		return new Jugada(jugadadto.getFechajug(), jugadadto.getUno(), jugadadto.getDos(),
				jugadorepo.findById(jugadadto.getJugador_id()).get());
	}

}
