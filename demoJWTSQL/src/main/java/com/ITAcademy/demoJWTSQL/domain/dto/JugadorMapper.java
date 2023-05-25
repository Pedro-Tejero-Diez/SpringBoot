package com.ITAcademy.demoJWTSQL.domain.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ITAcademy.demoJWTSQL.domain.models.Jugador;


@Component
public class JugadorMapper {

	public static JugadorDTO toJugadorDTO(Jugador jugador) {

		return new JugadorDTO(jugador.getJugador_id(), 
				jugador.getusername(), jugador.getJugadas());
		
		}

	public static Jugador toJugador(JugadorDTO jugadordto, String pwd) {

		LocalDate fechareg = LocalDate.now();

		return new Jugador(fechareg, jugadordto.getNombre(), pwd);

	}

}
