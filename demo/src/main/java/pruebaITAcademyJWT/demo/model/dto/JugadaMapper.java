package pruebaITAcademyJWT.demo.model.dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pruebaITAcademyJWT.demo.model.domain.Jugada;
import pruebaITAcademyJWT.demo.model.repository.JugadorRepository;



@Component
public class JugadaMapper {
	
	@Autowired
	static	JugadorRepository jugadorepo;

	public static JugadaDTO toJugadaDTO(Jugada jugada) {
		String jugador_id = jugada.getJugador().getJugador_id();
		LocalDate fechajug = jugada.getFechajug();
		byte uno = jugada.getUno();
		byte dos = jugada.getDos();

		return new JugadaDTO(jugador_id, fechajug, uno, dos);
	}

	public static Jugada toJugada(JugadaDTO jugadadto) {

		//Jugador jugador = jugadorepo.findById(jugadadto.getJugador_id()).get();
				
				
		return new Jugada(jugadadto.getFechajug(), 
				jugadadto.getUno(), jugadadto.getDos(), jugadorepo.findById(jugadadto.getJugador_id()).get());
	}

}
