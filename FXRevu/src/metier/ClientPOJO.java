package metier;

public class ClientPOJO {
	
	private int id_client;
	private String nom;
	private String prenom;
	private String num_rue;
	private String rue;
	private String cp;
	private String city;
	private String country;
	
	
	
	public ClientPOJO(int id_client, String nom, String prenom, String num_rue, String rue, String cp, String city,
			String country) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.num_rue = num_rue;
		this.rue = rue;
		this.cp = cp;
		this.city = city;
		this.country = country;
	}
	
	public ClientPOJO( String nom, String prenom, String num_rue, String rue, String cp, String city,
			String country) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.num_rue = num_rue;
		this.rue = rue;
		this.cp = cp;
		this.city = city;
		this.country = country;
	}
	
	
	public ClientPOJO() {
		
	}
	
	public ClientPOJO modify_client(ClientPOJO a) {
		
		this.id_client = a.id_client;
		this.nom = a.nom;
		this.prenom = a.prenom;
		this.num_rue = a.num_rue;
		this.rue = a.rue;
		this.cp = a.cp;
		this.city = a.city;
		this.country = a.country;
		
		
		return a;
	}



	public int getId_client() {
		return id_client;
	}



	public void setId_client(int id_client) {
		this.id_client = id_client;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNum_rue() {
		return num_rue;
	}



	public void setNum_rue(String num_rue) {
		this.num_rue = num_rue;
	}



	public String getRue() {
		return rue;
	}



	public void setRue(String rue) {
		this.rue = rue;
	}



	public String getCp() {
		return cp;
	}



	public void setCp(String cp) {
		this.cp = cp;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	@Override
	public String toString() {
		return "Client[id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", num_rue=" + num_rue
				+ ", rue=" + rue + ", cp=" + cp + ", city=" + city + ", country=" + country + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + id_client;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((num_rue == null) ? 0 : num_rue.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientPOJO other = (ClientPOJO) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (id_client != other.id_client)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (num_rue == null) {
			if (other.num_rue != null)
				return false;
		} else if (!num_rue.equals(other.num_rue))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		return true;
	}
	
	
	
	

}
