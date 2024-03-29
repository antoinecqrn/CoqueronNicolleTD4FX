package metier;


import java.time.LocalDate;

public class AbonnementPOJO {
	
	
	private int id_client;
	private int num_abo;
	private LocalDate datedeb;
	private LocalDate datefin;
	
	public AbonnementPOJO(int id_client, int num_abo, LocalDate d1, LocalDate d2) {
		super();
		this.id_client = id_client;
		this.num_abo = num_abo;
		this.datedeb = d1;
		this.datefin = d2;
	}
	
	public AbonnementPOJO() {
		
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getNum_abo() {
		return num_abo;
	}

	public void setNum_abo(int num_abo) {
		this.num_abo = num_abo;
	}

	public LocalDate getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(LocalDate datedeb) {
		this.datedeb = datedeb;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	@Override
	public String toString() {
		return "Abonnement [id_client=" + id_client + ", num_abo=" + num_abo + ", datedeb=" + datedeb + ", datefin="
				+ datefin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datedeb == null) ? 0 : datedeb.hashCode());
		result = prime * result + ((datefin == null) ? 0 : datefin.hashCode());
		result = prime * result + id_client;
		result = prime * result + num_abo;
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
		AbonnementPOJO other = (AbonnementPOJO) obj;
		if (datedeb == null) {
			if (other.datedeb != null)
				return false;
		} else if (!datedeb.equals(other.datedeb))
			return false;
		if (datefin == null) {
			if (other.datefin != null)
				return false;
		} else if (!datefin.equals(other.datefin))
			return false;
		if (id_client != other.id_client)
			return false;
		if (num_abo != other.num_abo)
			return false;
		return true;
	}

	

	
	
}
