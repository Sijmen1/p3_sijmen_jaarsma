package p3_package;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import p3_package.dao.Ov_ChipkaartDaoInterface;
import p3_package.dao.Ov_ChipkaartOracleDao;
import p3_package.dao.ProductDaoInterface;
import p3_package.dao.ProductOracleDao;
import p3_package.pojo.Product;
public class Main {
	

	public static void main(String[] args) throws ParseException {
		// all the testcode generated by me.
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ProductDaoInterface impl = new ProductOracleDao();
		Ov_ChipkaartDaoInterface ov_dao = new Ov_ChipkaartOracleDao();
		ProductDaoInterface pro_dao = new ProductOracleDao();
		System.out.println(ov_dao.findall());
		System.out.println(ov_dao.findByProductID(2));
		Product p = new Product();
		p.setBeschrijving("beschuit");
		p.setPrijs(50.0);
		p.setProductnaam("boarding");
		p.setProductnummer(2015);
		pro_dao.Save(p);
		
		p.setBeschrijving("boarding gaat nu 1 procent sneller op water");
		pro_dao.Update(p);
		pro_dao.Delete(p);
		}
}