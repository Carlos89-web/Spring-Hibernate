package conexionHibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalles_cliente")
public class DetallesCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	@Column(name="Web")
	private String web;
	@Column(name="Telefono")
	private String telefono;
	@Column(name="Comentarios")
	private String comentarios;
	
	// Creamos una variable objeto
	
	@OneToOne(mappedBy="detallesCliente")
	private Cliente elCliente;

	public DetallesCliente() {

	}

	public DetallesCliente(String web, String telefono, String comentarios) {
		this.web = web;
		this.telefono = telefono;
		this.comentarios = comentarios;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public Cliente getElCliente() {
		return elCliente;
	}

	public void setElCliente(Cliente elCliente) {
		this.elCliente = elCliente;
	}

	@Override
	public String toString() {
		return "DetallesCliente [Id=" + Id + ", web=" + web + ", telefono=" + telefono + ", comentarios=" + comentarios
				+ "]";
	}


}
