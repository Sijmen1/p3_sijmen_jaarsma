package p3_package.dao;
import java.util.ArrayList;

import p3_package.pojo.Ov_Chipkaart;
import p3_package.pojo.Reiziger;


public interface Ov_ChipkaartDaoInterface {
	// all standard DAO functionality
	public ArrayList<Ov_Chipkaart> findall();
	public boolean save(Ov_Chipkaart k);
	public boolean delete(Ov_Chipkaart k);
	public Ov_Chipkaart update(Ov_Chipkaart k);
	//this one exist to create a coupling function between reiziger and ov_chipkaart
	public ArrayList<Ov_Chipkaart> findByReiziger(Reiziger r1);
	public ArrayList<Integer> findByProductID(int productId);
	

}

