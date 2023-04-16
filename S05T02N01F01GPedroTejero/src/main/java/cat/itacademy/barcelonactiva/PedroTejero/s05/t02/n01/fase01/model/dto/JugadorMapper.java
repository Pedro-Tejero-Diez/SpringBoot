package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain.Jugador;

@Component
public class JugadorMapper {

	public static JugadorDTO toJugadorDTO(Jugador jugador) {

		return new JugadorDTO(jugador.getJugador_id(), jugador.getNombre());
	}

	public static Jugador toJugador(JugadorDTO jugadordto, String pwd) {
		
		LocalDate fechareg = LocalDate.now();
		
		return new Jugador(fechareg, jugadordto.getNombre(), pwd);

	}

}
