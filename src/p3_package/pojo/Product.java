package p3_package.pojo;

import java.util.ArrayList;

public class Product {
	private int productnummer;
	private String productnaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<Integer> ov_ChipkaartID;
	
	public Product() {
		super();
	}
	public int getProductnummer() {
		return productnummer;
	}

	public void setProductnummer(int productnummer) {
		this.productnummer = productnummer;
	}
	public String getProductnaam() {
		return productnaam;
	}
	public void setProductnaam(String productnaam) {
		this.productnaam = productnaam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public ArrayList<Integer> getOv_ChipkaartID() {
		return ov_ChipkaartID;
	}
	public void setOv_ChipkaartID(ArrayList<Integer> ov_ChipkaartID) {
		this.ov_ChipkaartID = ov_ChipkaartID;
	}
	@Override
	public String toString() {
		return "Product [productnummer=" + productnummer + ", productnaam=" + productnaam + ", beschrijving="
				+ beschrijving + ", prijs=" + prijs + ", ov_ChipkaartID=" + ov_ChipkaartID + "] \n";
	}
	
}
