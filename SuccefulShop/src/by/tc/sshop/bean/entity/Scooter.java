package by.tc.sshop.bean.entity;

import java.math.BigDecimal;

public class Scooter {
	private int idScooter;
	private String brand;
	private String model;
	private int wheeldiam;
    private String manufacturer;
    private String framematerial;    
    private String image;
    private String description;
    private int delSt;
    private BigDecimal price;
    private int discountPct;
	
    public Scooter() {
	}

	public Scooter(int idScooter, String brand, String model, int wheeldiam, String manufacturer, String framematerial,
			String image, String description, int delSt, BigDecimal price, int discountPct) {
		super();
		this.idScooter = idScooter;
		this.brand = brand;
		this.model = model;
		this.wheeldiam = wheeldiam;
		this.manufacturer = manufacturer;
		this.framematerial = framematerial;
		this.image = image;
		this.description = description;
		this.delSt = delSt;
		this.price = price;
		this.discountPct = discountPct;
	}

	public int getIdScooter() {
		return idScooter;
	}

	public void setIdScooter(int idScooter) {
		this.idScooter = idScooter;
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getFramematerial() {
		return framematerial;
	}

	public void setFramematerial(String framematerial) {
		this.framematerial = framematerial;
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
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + delSt;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + discountPct;
		result = prime * result + ((framematerial == null) ? 0 : framematerial.hashCode());
		result = prime * result + idScooter;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Scooter other = (Scooter) obj;
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
		if (framematerial == null) {
			if (other.framematerial != null)
				return false;
		} else if (!framematerial.equals(other.framematerial))
			return false;
		if (idScooter != other.idScooter)
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
		if (wheeldiam != other.wheeldiam)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Scooter [idScooter=" + idScooter + ", brand=" + brand + ", model=" + model + ", wheeldiam=" + wheeldiam
				+ ", manufacturer=" + manufacturer + ", framematerial=" + framematerial + ", image=" + image
				+ ", description=" + description + ", delSt=" + delSt + ", price=" + price + ", discountPct="
				+ discountPct + "]";
	}
    
    
}
