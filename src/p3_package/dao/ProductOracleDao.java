package p3_package.dao;

import java.sql.*;
import java.util.ArrayList;

import p3_package.pojo.Product;

public class ProductOracleDao extends OracleBaseDao implements ProductDaoInterface {

	@Override
	public ArrayList<Product> findall() {
		//finds all products
		ArrayList<Product> producten= new ArrayList();
		try(Connection conn = getConnection()){
			String sql= "Select * from product";
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			ResultSet rs=pstmnt.executeQuery();
			while(rs.next()) {
				Ov_ChipkaartOracleDao d =new Ov_ChipkaartOracleDao(); 
				Product p = new Product();
				p.setBeschrijving(rs.getString("beschrijving"));
				p.setPrijs(rs.getDouble("prijs"));
				p.setProductnaam(rs.getString("productnaam"));
				p.setProductnummer(rs.getInt("productnummer"));
				//get a list of all numbers of Ov_chipkaart that exist with this class.
				ArrayList<Integer> i= d.findByProductID(p.getProductnummer());
				p.setOv_ChipkaartID(i);
				producten.add(p);
			}
			
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return producten;
	}
	@Override
	public ArrayList<Product> getProductByOv(int cn){
		//specific class to find producten, used by ov_chipkaartDAO, to properly load everything
		ArrayList<Product> producten= new ArrayList();
		try(Connection conn = getConnection()){
			String sql= "select  Product.* from Product , OV_CHIPKAART_PRODUCT " + 
					"where Product.PRODUCTNUMMER = OV_CHIPKAART_PRODUCT.OVPRODUCTID " + 
					"and OV_Chipkaart_product.Kaartnummer = ?";
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			pstmnt.setInt(1,cn);
			ResultSet rs=pstmnt.executeQuery();
			while(rs.next()) {
				Ov_ChipkaartOracleDao d =new Ov_ChipkaartOracleDao(); 
				Product p = new Product();
				p.setBeschrijving(rs.getString("beschrijving"));
				p.setPrijs(rs.getDouble("prijs"));
				p.setProductnaam(rs.getString("productnaam"));
				p.setProductnummer(rs.getInt("productnummer"));
				ArrayList<Integer> i= d.findByProductID(p.getProductnummer());
				p.setOv_ChipkaartID(i);
				producten.add(p);
			}
			
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producten;
	}

	@Override
	public boolean Save(Product p) {
		boolean b = false;
		try(Connection conn = getConnection()){
			String sql = "insert into product(productnummer,productnaam,beschrijving,prijs) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getProductnummer());
			ps.setString(2, p.getProductnaam());
			ps.setString(3 , p.getBeschrijving());
			ps.setDouble(4, p.getPrijs());
			
			ps.execute();
			b=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Boolean Update(Product p) {
		try(Connection conn = getConnection()){
			String sql = "update product set productnaam = ?, beschrijving = ?, prijs = ? where productnummer = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getProductnaam());
			ps.setString(2, p.getBeschrijving());
			ps.setDouble(3, p.getPrijs());
			ps.setInt(4,p.getProductnummer());
			ps.execute();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean Delete(Product p) {
		boolean b = false;
		try(Connection conn = getConnection()){
			String sql= "delete from product where productnummer =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getProductnummer());
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	

}
