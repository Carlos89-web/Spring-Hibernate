package conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import HibernateUnoVarios.Pedido;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "Nombre")
	private String nombre;
	@Column(name = "Apellido")
	private String apellido;
	@Column(name = "Direccion")
	private String direccion;

	// Creamos una variable objeto y le hacemos el mapeo ORM (cascade=CascadeType.ALL). Le decimos
	// también la annotation para relacionar tablas. Gracias a CascadeType, se borran los registros
	// de las tablas relacionadas, es decir, si borramos un registro de la tabla clientes, también
	// se borrará de la tabla detalles_clientes.

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id")
	private DetallesCliente detallesCliente;
	
	// Para almacenar varios pedidos, creamos un campo de tipo List y le creamos la relación
	// @OneToMany. Mapeamos el campo que hemos creado en la tabla de pedidos, cliente es quién tiene
	// la annotation @ManyToOne, copiamos la cascade.
	
	@OneToMany(mappedBy="clienteId", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Pedido> pedido;

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
		id = id;
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
	
	public DetallesCliente getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(DetallesCliente detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	@Override
	public String toString() {
		return "Cliente [Id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}
	
	// Agregamos un campo que me permita agregar pedidos para el cliente en concreto
	// que me haya hecho estos pedidos. Para ello creamos un método. Este método recibe por
	// parámetro el pedido hecho por el cliente.
	
	public void agregarPedidos (Pedido elPedido) {
		
		// Si "pedido", que es la propiedad lista que hemos creado, está vacio, lo que tienes que
		// hacer es crear ese arraylist. Esto es como decir, que si me cesta de compra está vacia
		// Crea un arraylist, de tipo pedido, donde almacenar mi pedido. Con .add almacenamos el
		// pedido, con setClienteId, creamos el cliente, al que referenciamos con this, para indicar
		// que es la clase cliente donde nos encontramos
		
		if (pedido == null) pedido = new ArrayList<>();
		
		pedido.add(elPedido);
		
		elPedido.setClienteId(this);
	}

}
