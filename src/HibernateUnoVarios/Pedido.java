package HibernateUnoVarios;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import conexionHibernate.Cliente;

// --- VIDEO 60, 61 ---

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "FECHA")
	private GregorianCalendar fecha;
	
	@Column(name = "FORMA_PAGO")
	private String formaPago;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "CLIENTE_ID")
	private Cliente clienteId;
	
	public Pedido() {
		
		
	}
	
	public Pedido(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	
	// Video 61: El campo fecha no es necesario declararlo en el segundo constructor porque 
	// está en el primer constructor, y tampoco necesita getter ni setter

	public Pedido(String formaPago, Cliente clienteId) {
		this.formaPago = formaPago;
		this.clienteId = clienteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + ", formaPago=" + formaPago + "]";
	}

	
	
	

}
