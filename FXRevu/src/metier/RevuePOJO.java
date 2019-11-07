package metier;

public class RevuePOJO {
	
	private int id_revue;
	private String title;
	private String description;
	private double tarifnum;
	private String visuel;
	private int id_periode;
	
	
	
	public RevuePOJO(int id_revue, String title, String description, double tarifnum, String visuel, int id_periode) {
		super();
		this.id_revue = id_revue;
		this.title = title;
		this.description = description;
		this.tarifnum = tarifnum;
		this.visuel = visuel;
		this.id_periode = id_periode;
	}
	
	public RevuePOJO( String title, String description, double tarifnum,  int id_periode) {
		super();
		
		this.title = title;
		this.description = description;
		this.tarifnum = tarifnum;
		this.visuel = null;
		this.id_periode = id_periode;
	}
	
	public RevuePOJO() {
		
	}



	public int getId_revue() {
		return id_revue;
	}



	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getTarifnum() {
		return tarifnum;
	}



	public void setTarifnum(double tarifnum) {
		this.tarifnum = tarifnum;
	}



	public String getVisuel() {
		return visuel;
	}



	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}



	public int getId_periode() {
		return id_periode;
	}



	public void setId_periode(int id_periode) {
		this.id_periode = id_periode;
	}



	@Override
	public String toString() {
		return "Revue [id_revue=" + id_revue + ", title=" + title + ", description=" + description + ", tarifnum="
				+ tarifnum + ", visuel=" + visuel + ", id_periode=" + id_periode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id_periode;
		result = prime * result + id_revue;
		long temp;
		temp = Double.doubleToLongBits(tarifnum);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((visuel == null) ? 0 : visuel.hashCode());
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
		RevuePOJO other = (RevuePOJO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_periode != other.id_periode)
			return false;
		if (id_revue != other.id_revue)
			return false;
		if (Double.doubleToLongBits(tarifnum) != Double.doubleToLongBits(other.tarifnum))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (visuel == null) {
			if (other.visuel != null)
				return false;
		} else if (!visuel.equals(other.visuel))
			return false;
		return true;
	} 
	
	
	
	

}
