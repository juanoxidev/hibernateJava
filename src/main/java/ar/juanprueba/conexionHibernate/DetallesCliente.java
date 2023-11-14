package ar.juanprueba.conexionHibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class DetallesCliente {


		// name tal cual se llama en la bd
		@Id // primary key 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		@Column(name="web")
		private String web;
		@Column(name="telefono")
		private String telefono;
		@Column(name="comentarios")
		private String comentarios;
		
		
		public Cliente() {
		}

		public Cliente(String nombre, String apellido, String direccion) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.direccion = direccion;
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

		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
		}
		
}
