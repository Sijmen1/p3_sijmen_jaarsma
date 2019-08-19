package p3_package.pojo;
import java.util.ArrayList;
import java.util.Date;
public class Ov_Chipkaart {
	private int kaartnummer;
	private Date geldigtot;
	private int klasse;
	private double saldo;
	private Reiziger reiziger;
	private ArrayList<Product> producten = new ArrayList() ;
	//all code here is general information filled in in a way that the system required. 
	//This is just all properties that the OV_chipkaart has in the main system.
	public Ov_Chipkaart() {
		
	}
	public int getKaartnummer() {
		return kaartnummer;
	}
	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}
	public Date getGeldigtot() {
		return geldigtot;
	}
	public void setGeldigtot(Date geldigtot) {
		this.geldigtot = geldigtot;
	}
	public int getKlasse() {
		return klasse;
	}
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Reiziger getReiziger() {
		return reiziger;
	}
	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}
	public ArrayList<Product> getProducten() {
		return producten;
	}
	public void setProducten(ArrayList<Product> producten) {
		this.producten = producten;
	}
	@Override
	public String toString() {
		try {
			return "Ov_Chipkaart [kaartnummer=" + kaartnummer + ", geldigtot=" + geldigtot + ", klasse=" + klasse
					+ ", saldo=" + saldo + ", reiziger=" + reiziger.getReizigerid() + ", producten=" + producten + "]";}
		catch(NullPointerException e) {
			return "Ov_Chipkaart [kaartnummer=" + kaartnummer + ", geldigtot=" + geldigtot + ", klasse=" + klasse
					+ ", saldo=" + saldo + ",  producten=" + producten +   "] \n";
		}
	}
	
	

}
