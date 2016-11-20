package by.tc.sshop.bean.entity;

public class GoodsInOrders {
	private int idOrder;
	private int idBike;
	private int idScooter;
	private int idRoller;
	private int idAccessory;
	private String courier;
	
	public GoodsInOrders() {
		super();
	}

	public GoodsInOrders(int idOrder, int idBike, int idScooter, int idRoller, int idAccessory, String courier) {
		super();
		this.idOrder = idOrder;
		this.idBike = idBike;
		this.idScooter = idScooter;
		this.idRoller = idRoller;
		this.idAccessory = idAccessory;
		this.courier = courier;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courier == null) ? 0 : courier.hashCode());
		result = prime * result + idAccessory;
		result = prime * result + idBike;
		result = prime * result + idOrder;
		result = prime * result + idRoller;
		result = prime * result + idScooter;
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
		GoodsInOrders other = (GoodsInOrders) obj;
		if (courier == null) {
			if (other.courier != null)
				return false;
		} else if (!courier.equals(other.courier))
			return false;
		if (idAccessory != other.idAccessory)
			return false;
		if (idBike != other.idBike)
			return false;
		if (idOrder != other.idOrder)
			return false;
		if (idRoller != other.idRoller)
			return false;
		if (idScooter != other.idScooter)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsInOrders [idOrder=" + idOrder + ", idBike=" + idBike + ", idScooter=" + idScooter + ", idRoller="
				+ idRoller + ", idAccessory=" + idAccessory + ", courier=" + courier + "]";
	}
	
	

}
