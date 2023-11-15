package ar.juanprueba.conexionHibernateUnoAVarios;

import java.util.*;

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
	@OneToMany(fetch=FetchType.EAGER, mappedBy="cliente", cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Pedido> pedidos;
	
	//crear relacion 1 a 1 en mapeo ORM
	/*
	 * Cascade.ALL hace que si eliminamos un registro se borre tambien la informacion relacionada a otras tablas
	 * 
	 */
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

	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void agregarPedido(Pedido elPedido) {
		if(this.pedidos == null) {this.pedidos = new ArrayList<>();
		} 
		this.pedidos.add(elPedido);
		elPedido.setCliente(this);
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}

	
	
}
