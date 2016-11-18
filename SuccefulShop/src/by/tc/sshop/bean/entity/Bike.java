package by.tc.sshop.bean.entity;

import java.math.BigDecimal;

public class Bike {
	private int idBike;
	private String brand;
	private String model;
	private int wheeldiam;
    private String appointment;
    private String sex;
    private String manufacturer;
    private double framesize;
    private String framematerial;    
    private String equipment;
    private String image;
    private String description;
    private int delSt;
    private BigDecimal price;
    private int discountPct;
	
    public Bike() {
	}
    
	public Bike(String brand, String model, int wheeldiam, BigDecimal price) {
		this.brand = brand;
		this.model = model;
		this.wheeldiam = wheeldiam;
		this.price = price;
	}

	public Bike(int idBike, String brand, String model, int wheeldiam, String appointment, String sex,
			String manufacturer, double framesize, String framematerial, String equipment, String image,
			String description, int delSt, BigDecimal price, int discountPct) {
		super();
		this.idBike = idBike;
		this.brand = brand;
		this.model = model;
		this.wheeldiam = wheeldiam;
		this.appointment = appointment;
		this.sex = sex;
		this.manufacturer = manufacturer;
		this.framesize = framesize;
		this.framematerial = framematerial;
		this.equipment = equipment;
		this.image = image;
		this.description = description;
		this.delSt = delSt;
		this.price = price;
		this.discountPct = discountPct;
	}
	
	public int getIdBike() {
		return idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getWheeldiam() {
		return wheeldiam;
	}

	public void setWheeldiam(int wheeldiam) {
		this.wheeldiam = wheeldiam;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getFramesize() {
		return framesize;
	}

	public void setFramesize(double framesize) {
		this.framesize = framesize;
	}

	public String getFramematerial() {
		return framematerial;
	}

	public void setFramematerial(String framematerial) {
		this.framematerial = framematerial;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDelSt() {
		return delSt;
	}

	public void setDelSt(int delSt) {
		this.delSt = delSt;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getDiscountPct() {
		return discountPct;
	}

	public void setDiscountPct(int discountPct) {
		this.discountPct = discountPct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + delSt;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + discountPct;
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((framematerial == null) ? 0 : framematerial.hashCode());
		long temp;
		temp = Double.doubleToLongBits(framesize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idBike;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + wheeldiam;
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
		Bike other = (Bike) obj;
		if (appointment == null) {
			if (other.appointment != null)
				return false;
		} else if (!appointment.equals(other.appointment))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (delSt != other.delSt)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountPct != other.discountPct)
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		if (framematerial == null) {
			if (other.framematerial != null)
				return false;
		} else if (!framematerial.equals(other.framematerial))
			return false;
		if (Double.doubleToLongBits(framesize) != Double.doubleToLongBits(other.framesize))
			return false;
		if (idBike != other.idBike)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (wheeldiam != other.wheeldiam)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bike [idBike=" + idBike + ", brand=" + brand + ", model=" + model + ", wheeldiam=" + wheeldiam
				+ ", appointment=" + appointment + ", sex=" + sex + ", manufacturer=" + manufacturer + ", framesize="
				+ framesize + ", framematerial=" + framematerial + ", equipment=" + equipment + ", image=" + image
				+ ", description=" + description + ", delSt=" + delSt + ", price=" + price + ", discountPct="
				+ discountPct + "]";
	}

}
