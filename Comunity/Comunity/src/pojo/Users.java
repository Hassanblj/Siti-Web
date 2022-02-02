package pojo;

public class Users {

	//int sconsigliato quando lavoriamo con i database e utilizziamo, quindi, la classe wrapper degli interi ovvero "integer"
	private Integer id;
	private String cognome;
	private String nome;
	private String indirizzo;
	private String telefono;
	private String email;
	private String password;

	//costruttore di defoult???
	
	//costruttore senza id
	public Users(String cognome, String nome, String indirizzo, String telefono, String email, String password) {
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}
	//costruttore per accesso
	public Users(Integer id, String email, String pwd) {
			this.id = id;
			this.email = email;
			this.password = pwd;
		}


	//costruttore con tutti
	public Users(Integer id, String cognome, String nome, String indirizzo, String telefono, String email, String password) {
		this.id = id;
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Users [cognome=" + cognome + ", nome=" + nome + ", indirizzo=" + indirizzo + ", telefono=" + telefono
				+ ", id=" + id + ", email=" + email + ", password=" + password + "]";
	}



}
