package metier;

public class PeriodicitePOJO{
	
	private int id_periode;
	private String libelle ;
	
	
	
	
	
	public PeriodicitePOJO(int id_periode, String libelle) {
		
		this.id_periode = id_periode;
		this.libelle = libelle;
	}
	
	public PeriodicitePOJO() {
		
	}
	
	public PeriodicitePOJO( String libelle) {
		
		
		this(-1, libelle);
	}
	
	public int getId_periode() {
		return id_periode;
	}
	
	public void setId_periode(int id_periode) {
		this.id_periode = id_periode;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		
		if (libelle==null || libelle.trim().length()==0) {
			
			throw new IllegalArgumentException("Libelle vide!") ;
			
		}
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return libelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_periode;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		PeriodicitePOJO other = (PeriodicitePOJO) obj;
		if (id_periode != other.id_periode)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	} 
	
	

}
