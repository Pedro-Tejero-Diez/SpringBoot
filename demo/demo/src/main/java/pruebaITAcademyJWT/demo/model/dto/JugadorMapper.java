package pruebaITAcademyJWT.demo.model.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pruebaITAcademyJWT.demo.model.domain.Jugador;


@Component
public class JugadorMapper {

	
	public static JugadorDTO toJugadorDTO(Jugador jugador) {

		
		
		return new JugadorDTO(jugador.get_id(), 
				jugador.getNombre(), jugador.getJugadas()); 
		}

	public static Jugador toJugador(JugadorDTO jugadordto, String pwd) {

		LocalDate fechareg = LocalDate.now();

		return new Jugador(fechareg, jugadordto.getNombre(), pwd);

	}

}
