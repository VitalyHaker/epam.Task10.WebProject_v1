package by.tc.sshop.bean.entity;

public class Comment {
	private int idComment;
	private int idUser;
	private int idBike;
	private int idScooter;
	private int idRoller;
	private int idAccessory;
	private String comment;
	
	public Comment() {
	}
	
	public Comment(int idUser, int idBike, String comment) {
		this.idUser = idUser;
		this.idBike = idBike;
		this.comment = comment;
	}

	public Comment(int idUser, int idBike, int idScooter, int idRoller, int idAccessory, String comment) {
		this.idUser = idUser;
		this.idBike = idBike;
		this.idScooter = idScooter;
		this.idRoller = idRoller;
		this.idAccessory = idAccessory;
		this.comment = comment;
	}
	
	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdBike() {
		return idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	public int getIdScooter() {
		return idScooter;
	}

	public void setIdScooter(int idScooter) {
		this.idScooter = idScooter;
	}

	public int getIdRoller() {
		return idRoller;
	}

	public void setIdRoller(int idRoller) {
		this.idRoller = idRoller;
	}

	public int getIdAccessory() {
		return idAccessory;
	}

	public void setIdAccessory(int idAccessory) {
		this.idAccessory = idAccessory;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + idAccessory;
		result = prime * result + idBike;
		result = prime * result + idComment;
		result = prime * result + idRoller;
		result = prime * result + idScooter;
		result = prime * result + idUser;
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
		Comment other = (Comment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (idAccessory != other.idAccessory)
			return false;
		if (idBike != other.idBike)
			return false;
		if (idComment != other.idComment)
			return false;
		if (idRoller != other.idRoller)
			return false;
		if (idScooter != other.idScooter)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", idUser=" + idUser + ", idBike=" + idBike + ", idScooter="
				+ idScooter + ", idRoller=" + idRoller + ", idAccessory=" + idAccessory + ", comment=" + comment + "]";
	}

}
