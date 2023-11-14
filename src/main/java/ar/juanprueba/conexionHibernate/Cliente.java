package ar.juanprueba.conexionHibernate;

import jakarta.persistence.*;
// Mapeo ORM Hibernate
@Entity
@Table(name="cliente")
public class Cliente {
	
	// name tal cual se llama en la bd
	@Id // primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="direccion")
	private String direccion;
	
	//crear relacion 1 a 1 en mapeo ORM
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private DetallesCliente detallesCLlientes;
	
	

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
	}

	public DetallesCliente getDetallesCLlientes() {
		return detallesCLlientes;
	}

	public void setDetallesCLlientes(DetallesCliente detallesCLlientes) {
		this.detallesCLlientes = detallesCLlientes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	
}
