package p3_package.dao;

import java.util.ArrayList;
import java.util.Date;

import p3_package.pojo.Reiziger;

public interface ReizigerDaoInterface {
	//still only default programs
	public ArrayList<Reiziger> findall();
	public ArrayList<Reiziger> findByGBdatum(String GBdatum);
	public Reiziger save(Reiziger r);
	public Reiziger update(Reiziger r);
	public boolean delete(Reiziger r);

}
