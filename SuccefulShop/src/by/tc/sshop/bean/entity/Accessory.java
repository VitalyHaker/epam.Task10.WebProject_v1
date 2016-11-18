package by.tc.sshop.bean.entity;

import java.math.BigDecimal;

public class Accessory {
	private int idAccssory;
	private String name;
	private String model;
    private String manufacturer;
    private String image;    
    private String description;
    private int delSt;
    private BigDecimal price;
    private int discountPct;
	
    public Accessory() {
		super();
	}

	public Accessory(int idAccssory, String name, String model, String manufacturer, String image, String description,
			int delSt, BigDecimal price, int discountPct) {
		super();
		this.idAccssory = idAccssory;
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
		this.image = image;
		this.description = description;
		this.delSt = delSt;
		this.price = price;
		this.discountPct = discountPct;
	}

	public int getIdAccssory() {
		return idAccssory;
	}

	public void setIdAccssory(int idAccssory) {
		this.idAccssory = idAccssory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
		result = prime * result + delSt;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + discountPct;
		result = prime * result + idAccssory;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Accessory other = (Accessory) obj;
		if (delSt != other.delSt)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountPct != other.discountPct)
			return false;
		if (idAccssory != other.idAccssory)
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accessory [idAccssory=" + idAccssory + ", name=" + name + ", model=" + model + ", manufacturer="
				+ manufacturer + ", image=" + image + ", description=" + description + ", delSt=" + delSt + ", price="
				+ price + ", discountPct=" + discountPct + "]";
	}
    
}
