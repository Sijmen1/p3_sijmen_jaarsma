package p3_package.dao;

import java.util.ArrayList;

import p3_package.pojo.Product;

public interface ProductDaoInterface {
	public ArrayList<Product> findall();
	public boolean Save(Product p);
	public Boolean Update(Product p);
	public Boolean Delete(Product p);
	//returns all products for the OV_chipkaart to find
	public ArrayList<Product> getProductByOv(int cn);
}
