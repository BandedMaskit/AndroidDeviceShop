package data;

public class Device {
	public int deviceid;
	public String productname;
	public ProductType producttype;
	public int memorycapacity;
	public String os;
	public String processor;
	public int ram;
	public double price;
	
	public enum ProductType {
		Phone, Tablet
	}

	public int getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(int deviceid) {
		this.deviceid = deviceid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public ProductType getProducttype() {
		return producttype;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	public int getMemorycapacity() {
		return memorycapacity;
	}

	public void setMemorycapacity(int memorycapacity) {
		this.memorycapacity = memorycapacity;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}


	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Device(int deviceid, String productname, ProductType producttype, int memorycapacity, String os, String processor, int ram, double price ){
		this.deviceid = deviceid;
		this.productname = productname;
		this.producttype = producttype;
		this.memorycapacity = memorycapacity;
		this.os = os;
		this.processor = processor;
		this.ram = ram;
		this.price = price;
	}
	

}
