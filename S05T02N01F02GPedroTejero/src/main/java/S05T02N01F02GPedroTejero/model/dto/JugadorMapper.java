package S05T02N01F02GPedroTejero.model.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import S05T02N01F02GPedroTejero.model.domain.Jugador;

@Component
public class JugadorMapper {

	public static JugadorDTO toJugadorDTO(Jugador jugador) {

		return new JugadorDTO(jugador.getJugador_id(), 
				jugador.getNombre(), jugador.getJugadas());
		
		}

	public static Jugador toJugador(JugadorDTO jugadordto, String pwd) {

		LocalDate fechareg = LocalDate.now();

		return new Jugador(fechareg, jugadordto.getNombre(), pwd);

	}

}
