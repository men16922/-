package bb;

import java.sql.*;
import java.util.*;

public class PriceDAO {

	private Connection conn; // connection:db?��?��근하�? ?��주는 객체
	private ResultSet rs;
	int pageNumber = 1;
	Test s=new Test();
	public PriceDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(s.rurl, s.root, s.rootpw);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// bbsID 게시�? 번호 �??��?��?�� ?��?��

	public int getNext() {

		String SQL = "SELECT idprice FROM price ORDER BY idprice DESC";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				return rs.getInt(1) + 1;

			}

			return 1;// �? 번째 게시물인 경우

		} catch (Exception e) {

			e.printStackTrace();

		}

		return -1; // ?��?��?��베이?�� ?���?

	}

	// ?��?���? �??�� ?��?��?��?�� ?��?��

	public int write(String price, String year) {

		String SQL = "INSERT INTO price VALUES(?, ?, ?)";

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setInt(1, getNext());

			pstmt.setString(2, price);

			pstmt.setString(3, year);

			return pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return -1; // ?��?��?��베이?�� ?���?

	}

	public ArrayList<Price> getList() {// int pageNumber) {

		String SQL = "SELECT * FROM price"; // WHERE idprice < ? ORDER BY idprice DESC LIMIT 10";

		ArrayList<Price> list = new ArrayList<Price>();

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);
	

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Price price = new Price();
				price.setIdprice(rs.getInt(1));
				price.setPrice(rs.getInt(2));
				price.setYear(rs.getInt(3));
				list.add(price);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;

	}

	public ArrayList<Price> getavgList() {// int pageNumber) {

		String SQL = "SELECT * FROM test.avg_view";// WHERE idprice < ? ORDER BY idprice DESC LIMIT 10";

		ArrayList<Price> list1 = new ArrayList<Price>();

		try {

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Price avgprice = new Price();
			
				avgprice.setAvgYear(rs.getInt(1));
				avgprice.setAvgPrice(rs.getInt(2));
				list1.add(avgprice);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return list1;

	}

	public ArrayList<Price> getListmax_min() {// int pageNumber) {

		String SQL = "SELECT * FROM test.maxmin_view"; // WHERE idprice < ? ORDER BY idprice DESC LIMIT 10";

		ArrayList<Price> list = new ArrayList<Price>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Price price = new Price();
				price.setMax_year(rs.getInt(1));
				price.setMax_price(rs.getInt(2));
				list.add(price);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	

}
