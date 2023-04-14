package cat.itacademy.barcelonactiva.PedroTejero.s05.t02.n01.fase01.model.domain;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Jugada {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jugada_id;

	@Column(name = "fecha de jugada")
	private Date fechajug;

	@Column(name = "dado 1")
	private byte uno;

	@Column(name = "dado 2")
	private byte dos;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "jugador_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Jugador jugador;
}
