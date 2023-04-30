package S05T02N01F02GPedroTejero.model.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import S05T02N01F02GPedroTejero.model.domain.Jugada;
import S05T02N01F02GPedroTejero.model.domain.Jugador;
import S05T02N01F02GPedroTejero.model.services.JugadaServiceImpl;

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
