package ar.juanprueba.conexionHibernateUnoAUno;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="detallescliente")
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
		/* relacion bidireccional 
		
		Si no indicamos que tipo de cascada y hay un cliente asociado al detalle va a tirarnos un error de tipo EntityNotFoundException, ya que 
		el objeto eliminado va a ser re escrito por el cliente por la relacion bidireccional, aun si se desvincula el cliente del detalledecliente lanzaria otro error 
		ya que la tabla cliente tiene como clave foranea el detallecliente que apunta al id del detallecliente, si yo elimino el detallecliente, va a tirar error ya que 
		no se puede eliminar algo a lo que esta haciendo referencia el cliente. Para ello la unica solucion es eliminar al cliente y en conjunto borre el detalle.
		con cascadeType.ALL va a eliminar todos los registros de las tablas donde se haga referencia el detalleDelCLiente que indiquemos ej. EliminaClienteRelacion1a1Bidireccional.

		*/
		@OneToOne(mappedBy="detallesCliente", cascade = CascadeType.ALL)
		private Cliente cliente;
		
		
	


		public DetallesCliente() {
		}




		public DetallesCliente(String web, String telefono, String comentarios) {
			this.web = web;
			this.telefono = telefono;
			this.comentarios = comentarios;
		}




		public int getId() {
			return id;
		}




		public void setId(int id) {
			this.id = id;
		}




		public String getWeb() {
			return web;
		}




		public void setWeb(String web) {
			this.web = web;
		}




		public String getTelefono() {
			return telefono;
		}




		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}




		public String getComentarios() {
			return comentarios;
		}




		public void setComentarios(String comentarios) {
			this.comentarios = comentarios;
		}
		
		
		public Cliente getCliente() {
			return cliente;
		}




		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}




		@Override
		public String toString() {
			return "DetallesCliente [id=" + id + ", web=" + web + ", telefono=" + telefono + ", comentarios="
					+ comentarios + "]";
		}
		
		
		
}
