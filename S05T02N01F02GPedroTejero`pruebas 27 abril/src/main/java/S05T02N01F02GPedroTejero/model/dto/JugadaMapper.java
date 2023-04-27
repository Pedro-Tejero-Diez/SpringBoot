package S05T02N01F02GPedroTejero.model.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import S05T02N01F02GPedroTejero.model.domain.Jugada;
import S05T02N01F02GPedroTejero.model.domain.Jugador;


@Component
public class JugadaMapper {

	public static JugadaDTO toJugadaDTO(Jugada jugada) {
		Jugador jugador = jugada.getJugador();
		LocalDate fechajug = jugada.getFechajug();
		byte uno = jugada.getUno();
		byte dos = jugada.getDos();

		return new JugadaDTO(jugador, fechajug, uno, dos);
	}

	public static Jugada toJugada(JugadaDTO jugadaDTO) {

		return new Jugada(jugadaDTO.getJugador(), jugadaDTO.getFechajug(), 
				jugadaDTO.getUno(), jugadaDTO.getDos());
	}

}
