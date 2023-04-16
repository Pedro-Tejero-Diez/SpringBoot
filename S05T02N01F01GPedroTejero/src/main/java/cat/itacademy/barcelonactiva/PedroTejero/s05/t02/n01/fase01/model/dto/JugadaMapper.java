package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto;


import java.time.LocalDate;

import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugada;
import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;

@Component
public class JugadaMapper {

	public static JugadaDTO toJugadaDTO(Jugada jugada) {
		Integer jugador_id = jugada.getJugador().getJugador_id();
		LocalDate fechajug = jugada.getFechajug();
		byte uno = jugada.getUno();
		byte dos = jugada.getDos();

		return new JugadaDTO(jugador_id, fechajug, uno, dos);
	}

	public static Jugada toJugada(JugadaDTO jugadaDTO, Jugador jugador) {
		
		return new Jugada(jugador.getJugador_id(),jugadaDTO.getFechajug(), jugadaDTO.getUno(), jugadaDTO.getDos(), jugador); 
	}

}
