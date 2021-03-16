package mx.edu.uacm.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import mx.edu.uacm.dominio.enumeraciones.EstadoUsuario;


@Entity
@Table(name = "USUARIOS")
//@SequenceGenerator(name = "usuario_sec", sequenceName = "usuario_sec", initialValue = 1, allocationSize = 1)
public class Usuario {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sec")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_usuario", length = 100)
	private String nombreUsuario;
	
	@Column(name = "mensaje_usuario")
	private String mensajeUsuario;
	
	//@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento", nullable = false)
	private LocalDate fechaNacimiento;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false, updatable = false)
	private LocalDateTime fechaRegistro=LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 10)
	private EstadoUsuario status;
	
	public EstadoUsuario getStatus() {
		return status;
	}

	public void setStatus(EstadoUsuario status) {
		this.status = status;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		
		this.fechaRegistro = fechaRegistro;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}
	
	

}
