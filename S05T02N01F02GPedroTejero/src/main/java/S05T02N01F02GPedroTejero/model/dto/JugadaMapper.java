package S05T02N01F02GPedroTejero.model.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import S05T02N01F02GPedroTejero.model.domain.Jugada;
import S05T02N01F02GPedroTejero.model.domain.Jugador;


@Component
public class JugadaMapper {

	public static JugadaDTO toJugadaDTO(Jugada jugada) {
		Integer jugador_id = jugada.getJugador_id();
		LocalDate fechajug = jugada.getFechajug();
		byte uno = jugada.getUno();
		byte dos = jugada.getDos();

		return new JugadaDTO(jugador_id, fechajug, uno, dos);
	}

	public static Jugada toJugada(JugadaDTO jugadaDTO, Jugador jugador) {

		return new Jugada(jugador.getJugador_id(), jugadaDTO.getFechajug(), 
				jugadaDTO.getUno(), jugadaDTO.getDos());
	}

}
