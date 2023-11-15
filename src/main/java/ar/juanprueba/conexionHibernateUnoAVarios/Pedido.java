package ar.juanprueba.conexionHibernateUnoAVarios;

import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name="pedido")
public class Pedido {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
	private int id;
@Column(name="fecha")
	private Date fecha;
@Column(name="forma_pago")
private String formaPago;
@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
// JoinColumn la tabla perdido se relaciona con la tabla cliente por la columna cliente_id
@JoinColumn(name="cliente_id")	
private Cliente cliente;



public Pedido() {
}

public Pedido(Date fecha) {
	this.fecha = fecha;
}

public String getFormaPago() {
	return formaPago;
}

public void setFormaPago(String formaPago) {
	this.formaPago = formaPago;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

@Override
public String toString() {
	return "Pedido [id=" + id + ", fecha=" + fecha + ", formaPago=" + formaPago + "]";
}



	
}
