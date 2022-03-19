package bb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Test {
	public static String root="root";
	public static String rootpw="1692";
	public static String rurl="jdbc:mysql://localhost/test";
	public static int loginCheck=0;
	public static int redunCheck=0;
	public static String loginid="";
	 public static String result="";
	 public static String [] words = new String[15];
	 public static String titleid="";
	 public static String []scenarios = new String[25];
	 public static String mysql= "";
	 public static String[] arr = {"남북한 언어 비교", "남북한 자연환경","남북한 도시", "남북한 인구통계","남북한 자원"};
		public static int [] num = new int[5];
	 
	 class Typetester {


	
		 String printType(int x) {

			 String s;
		 s=Integer.toString(x);

		 return s;
		 }
		 
		 String printType(float x) {

			 String s;
		 s=Float.toString(x);

		 return s;
		 }
		 
		 String printType(String x) {

			 String s;
		 s=x;

		 return s;
		 }
	 }
	 public static void asc(String text) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "select * from time_view order by date asc";	
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            rs.last();
	            int last = rs.getRow();
	            rs.beforeFirst();
	            
	        	String [] header = {"No","title","date"};
			 	String [][] contents = new String[last][3];
			 	int i=0;
			 	while(rs.next()) {
	            	String tmp = rs.getString(1);
	            	if(tmp.contains(text)) {
	            		
		            	contents[i][0] = Integer.toString(i+1);
		            	contents[i][1] = tmp;
		            	contents[i][2] = rs.getString(2);
		            	i++;
	            	}
		        }
	            P_Search2.table.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm =  P_Search2.table.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);

				tm.getColumn(0).setPreferredWidth(30);
				tm.getColumn(1).setPreferredWidth(90);
				tm.getColumn(2).setPreferredWidth(90);

	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }	
		}
		
		public static void desc(String text) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "select * from time_view order by date desc";	
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            rs.last();
	            int last = rs.getRow();
	            rs.beforeFirst();
	            
	        	String [] header = {"No","title","date"};
			 	String [][] contents = new String[last][3];
			 	int i=0;
			 	while(rs.next()) {
	            	String tmp = rs.getString(1);
	            	if(tmp.contains(text)) {
	            		
		            	contents[i][0] = Integer.toString(i+1);
		            	contents[i][1] = tmp;
		            	contents[i][2] = rs.getString(2);
		            	i++;
	            	}
		        }
	            P_Search2.table.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm =  P_Search2.table.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);

				tm.getColumn(0).setPreferredWidth(30);
				tm.getColumn(1).setPreferredWidth(90);
				tm.getColumn(2).setPreferredWidth(90);

	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }	
		}

		public static void searchNewV(String text) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "select * from time_view";	
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            rs.last();
	            int last = rs.getRow();
	            rs.beforeFirst();
	            
	        	String [] header = {"No","title","date"};
			 	String [][] contents = new String[last][3];
			 	int i=0;
	            while(rs.next()) {
	            	String tmp = rs.getString(1);
	            	if(tmp.contains(text)) {
	            		
		            	contents[i][0] = Integer.toString(i+1);
		            	contents[i][1] = tmp;
		            	contents[i][2] = rs.getString(2);
		            	i++;
	            	}
	            }
	            P_Search2.table.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm =  P_Search2.table.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);

				tm.getColumn(0).setPreferredWidth(30);
				tm.getColumn(1).setPreferredWidth(90);
				tm.getColumn(2).setPreferredWidth(90);

	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }	
		}
		
		public static boolean checkWord(String word) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        boolean flag= false;
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "select userid,word from searchword";	
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	          
	     		int i=0;
	            while(rs.next()) {
	            	if(rs.getString(1).equals(loginid) && rs.getString(2).equals(word)) {
	            		flag = true;
	            		break;
	            	}          	
	            }
	           
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	        return flag;
		}
		
		public static void insertWord(String word) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);
	            String sql="";
	            if(checkWord(word))	// 같은 아이디, 단어 잇는 경우 체크
	            	sql = "update searchword set time = now() where userid = ? and word = ?";
	            else
	            	sql = "insert into searchword values(?,?,now())";
	            
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, loginid);
	            pstmt.setString(2, word);
	            int a = pstmt.executeUpdate();
	        
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
		}
		
		public static void recentTop() {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "select word, time from recent_view where userid = ? limit 5";	
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, loginid);
	            rs = pstmt.executeQuery();
	            
	        	String [] header = {"No","word","time"};
			 	String [][] contents = new String[5][3];
			 	int i=0;
	            while(rs.next()) {
	            	contents[i][0] = Integer.toString(i+1);
	            	contents[i][1] = rs.getString(1);
	            	contents[i][2] = rs.getString(2);
	            	i++;
	            }
	            P_RecentTop5.table3.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm =  P_RecentTop5.table3.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);

				tm.getColumn(0).setPreferredWidth(30);
				tm.getColumn(1).setPreferredWidth(90);
				tm.getColumn(2).setPreferredWidth(90);

	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
		}
		
		public static void viewTop() {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "select * from count_view order by count desc limit 5";	
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            
	        	String [] header = {"Title","count"};
			 	String [][] contents = new String[5][2];
			 	int i=0;
	            while(rs.next()) {
	            	
	            	contents[i][0] = rs.getString(1);
	            	contents[i][1] = rs.getString(2);
	            	i++;
	            }
	            P_ViewTop5.table3.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm =  P_ViewTop5.table3.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(0).setPreferredWidth(80);
				tm.getColumn(1).setPreferredWidth(80);
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
		}
		
		public static void countUp(String tname) {
			Connection conn = null;
	        PreparedStatement pstmt = null;

	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	        	String sql = "UPDATE tablecount set count = count + 1 where tableName = ? ";	
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, tname);
	            int a = pstmt.executeUpdate();
	        
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	        
		}
		
		public static void show(String tname, int row) {
			Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;

	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);
	            System.out.println(tname);
	        	String sql = "SELECT * from "+tname;	
	            pstmt = conn.prepareStatement(sql);

	            rs = pstmt.executeQuery();
	            rs.last();
	            int last = rs.getRow();
	            rs.beforeFirst();
	            
	            ResultSetMetaData rm = rs.getMetaData();
	            int col = rm.getColumnCount();
	            String [][] contents = new String[last][col];
	            int i=0;
	            while(rs.next()) {
	            	for(int k=0;k<col;k++) {
	            		contents[i][k] = rs.getString(k+1);       		
	            	}
	            
	            	i++;
	            }
	            
	            String [] header = new String[7];
					if(tname.equals("dictionary")){
						header[0] = "id";  header[1] = "north";  header[2] = "south";  
					}else if(tname.equals("environment")) {
						header[0] = "distribution";  header[1] = "year";  header[2] = "temperature";  
						header[3] = "precipitation";  header[4] = "wind_speed";  header[5] = "ns";  					
					}else if(tname.equals("city")) {
						header[0] = "name";   
					}else if(tname.equals("population_ns")) {
						header[0] = "year";  header[1] = "population";  header[2] = "population_density";  
						header[3] = "male";  header[4] = "female";  header[5] = "sex_ratio"; header[6] = "birth_since_nationaldivision"; 				
					}else if(tname.equals("resources")) {
						header[0] = "year";  header[1] = "coal";  header[2] = "iron_ore";  header[3] = "crude_steel";  header[4] = "ns";  					
					}
							
									
		    	P_Show.table2.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm = P_Show.table2.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);
				tm.getColumn(0).setPreferredWidth(80);
				tm.getColumn(1).setPreferredWidth(80);
				tm.getColumn(2).setPreferredWidth(80);
				
			
	        
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
		
	}
		
		public static String titleToTable(String title) {
				Connection conn = null;
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        String tname="";

		        try{
		            // 1. 드라이버 로딩
		            Class.forName("com.mysql.jdbc.Driver");

		            // 2. 연결하기
		            String url = rurl;
		            conn = DriverManager.getConnection(url, root, rootpw);

	            	String sql = "SELECT tableName FROM tablecount where title = ? ";	
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, title);
		            rs = pstmt.executeQuery();
		            
		            if(rs.next()) {
		            	tname = rs.getString(1);
		            }
		        
		        }
		        catch( ClassNotFoundException e){
		            System.out.println("드라이버 로딩 실패");
		        }
		        catch( SQLException e){
		            System.out.println("에러 " + e);
		        }
		        finally{
		            try{
		                if( conn != null && !conn.isClosed()){
		                    conn.close();
		                }
		                if( pstmt != null && !pstmt.isClosed()){
		                    pstmt.close();
		                }
		            }
		            catch( SQLException e){
		                e.printStackTrace();
		            }
		        }
			return tname;
		}
		
		 public static void searchUpdate(String tmp) {
			 	num[0] = searchUp(tmp,"dictionary");
			 	num[1] = searchUp(tmp,"environment");
			 	num[2] = searchUp(tmp,"city");
			 	num[3] = searchUp(tmp,"population_ns");
			 	num[4] = searchUp(tmp,"resources");
			 	
			 	int count=0;
			 	for(int i=0;i<5;i++) {
			 		if(num[i]==1)
			 			count++;
			 	}
			 	
			 	String [] header = {"Number","Title","button"};
			 	String [][] contents = new String[count][3];
			 	
			 	count=0;
			 	for(int i=0;i<5;i++) {
			 		if(num[i]==1) {		 			
			 			contents[count][0] = Integer.toString(count+1);
			 			contents[count][1] = arr[i];
			 			count++;
			 		}
			 	}

		   
		    
		    	P_Search.table.setModel(new DefaultTableModel(contents, header));
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm = P_Search.table.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);
				tm.getColumn(0).setPreferredWidth(50);
				tm.getColumn(1).setPreferredWidth(330);
				tm.getColumn(2).setPreferredWidth(80);
				
				tm.getColumn(2).setCellRenderer(new EnterButton());	// 버튼 나타나도록
				tm.getColumn(2).setCellEditor(new EnterButton());		// 버튼 눌럿을때 동작하도록
				
//				JScrollPane jsp = new JScrollPane(P_Search.table);
//				jsp.setSize(450, 500);
//				jsp.setLocation(110, 200);
//				P_Search.sear.add(jsp);
		}
		 
		 public static int searchUp(String tmp, String tableName) {	// 검색한 텍스트를 포함하는 
			 	Connection conn = null;
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;
		        String id="",pw="", sql="", title="";
	            int count =0;
		        try{
		            // 1. 드라이버 로딩
		            Class.forName("com.mysql.jdbc.Driver");

		            // 2. 연결하기
		            String url = rurl;
		            conn = DriverManager.getConnection(url, root, rootpw);
		         
		            // 3. 쿼리 수행을 위한 Statement 객체 생성
		            if(tableName.equals("dictionary")) {
		            	sql = "SELECT * FROM "+tableName+" where ? in (id,north,south) ";
		            	title= arr[0];	// 이 부분 이렇게 말고 DB에서 dictionary 에 해당하는 title 가져오는 식으로
		            }
		            else if(tableName.equals("environment")) {
		            	sql = "SELECT * FROM "+tableName+" where ? in (distribution,year,temperature,precipitation,wind_speed,'ns') ";
		            	title = arr[1];
		            }
		            else if(tableName.equals("city")) {
		            	System.out.println("통과");
		            	sql = "SELECT * FROM "+tableName+" where ? in (name) ";
		            	title = arr[2];
		            }
		            else if(tableName.equals("population_ns")) {
		            	sql = "SELECT * FROM "+tableName+" where ? in (year,population,population_density,male,female,sexratio,birth_since_nationaldivision) ";
		            	title = arr[3];
		            }
		            else if(tableName.equals("resources")) {
		            	sql = "SELECT * FROM "+tableName+" where ? in (year,coal,iron_ore,crude_steel,'ns') ";	
		            	title = arr[4];
		            }
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, tmp);

		            // 5. 쿼리 수행
		            // 레코드들은 ResultSet 객체에 추가된다.
		            rs = pstmt.executeQuery();
		          
		            String [] header = {"Number","Title","button"};
		            String [][] contents = {};
			   
			    
		            if(rs.next()||title.contains(tmp)){
		                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
		                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
		            	contents = new String[1][3];
		    	    	contents[0][0] =  "1";
		    	    	contents[0][1] =  title;
		    	    	count = 1;
		            }
		           
		            
			    	P_Search.table.setModel(new DefaultTableModel(contents, header));

		        }
		        catch( ClassNotFoundException e){
		            System.out.println("드라이버 로딩 실패");
		        }
		        catch( SQLException e){
		            System.out.println("에러 " + e);
		        }
		        finally{
		            try{
		                if( conn != null && !conn.isClosed()){
		                    conn.close();
		                }
		                if( pstmt != null && !pstmt.isClosed()){
		                    pstmt.close();
		                }
		                if( rs != null && !rs.isClosed()){
		                    rs.close();
		                }
		            }
		            catch( SQLException e){
		                e.printStackTrace();
		            }
		        }
				
		    	DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
				dt.setHorizontalAlignment(SwingConstants.CENTER);
				TableColumnModel tm = P_Search.table.getColumnModel();
				tm.getColumn(0).setCellRenderer(dt);
				tm.getColumn(1).setCellRenderer(dt);
				tm.getColumn(2).setCellRenderer(dt);
				tm.getColumn(0).setPreferredWidth(50);
				tm.getColumn(1).setPreferredWidth(330);
				tm.getColumn(2).setPreferredWidth(80);
				
				tm.getColumn(2).setCellRenderer(new EnterButton());	// 버튼 나타나도록
				tm.getColumn(2).setCellEditor(new EnterButton());		// 버튼 눌럿을때 동작하도록
				
				return count;
			
		}		 
	 
	public  void update(String id, String pw, String name, String classname){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // 1. 드라이버 로딩
        	Class.forName("com.mysql.jdbc.Driver");

            // 2. 연결하기
        	String url = rurl;
            conn = DriverManager.getConnection(url, root, rootpw);

//			pstmt = conn.prepareStatement("update user set password = ?, name = ?, class = ? where id = ?");
//			System.out.println(pw+name+classname+id);
//			pstmt.setString(1, pw);
//			pstmt.setString(2, name);
//			pstmt.setString(3, classname);
//			pstmt.setString(4, id);
            StringBuilder sb = new StringBuilder();

            String sql = sb.append("update user set password = '"+ pw + "', name ='"+ name +"', class= '"+classname+ "' where id ='" + id +"' ")
                    .append(";")
                    .toString();


            pstmt = conn.prepareStatement(sql);
            int count = pstmt.executeUpdate();
            if( count == 0 ){
                System.out.println("데이터 입력 실패");
            }
            else{
                System.out.println("데이터 입력 성공");
            }
        }
        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
	
	 public void delete(String id){
	        Connection conn = null;
	        PreparedStatement pstmt = null;

	        try{
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            StringBuilder sb = new StringBuilder();	         
	            String sql = sb.append("DELETE FROM user WHERE id= "+ "'" + id +"'")
	                    .append(";")
	                    .toString();


	            pstmt = conn.prepareStatement(sql);
	            int count = pstmt.executeUpdate();
	            if( count == 0 ){
	                System.out.println("데이터 입력 실패");
	            }
	            else{
	                System.out.println("데이터 입력 성공");
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	 }
	 
	 public static void showuser() {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        String id,pw=null;
	        try{
	            // 1. 드라이버 로딩
	            Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	            String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            // 3. 쿼리 수행을 위한 Statement 객체 생성
	            stmt = conn.createStatement();
	            String sql = "SELECT * FROM user";

	            // 5. 쿼리 수행
	            // 레코드들은 ResultSet 객체에 추가된다.
	            rs = stmt.executeQuery(sql);
	           
	           
	            // 6. 실행결과 출력하기
	            
	            String [] header = {"No","Name","ID","pw","class"};
	            String [][] contents = new String[7][5];
	            int i=0;
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                contents[i][0]= rs.getString(1);
	                contents[i][1]= rs.getString(2);
	                contents[i][2]= rs.getString(3);
	                contents[i][3]= rs.getString(4);
	                contents[i][4]= rs.getString(5);

	                i++;         
	            }
	            P_Profile.table2.setModel(new DefaultTableModel(contents, header));
	            DefaultTableCellRenderer dt = new DefaultTableCellRenderer();
	            dt.setHorizontalAlignment(SwingConstants.CENTER);
	            TableColumnModel tm = P_Profile.table2.getColumnModel();
	            tm.getColumn(0).setCellRenderer(dt);
	            tm.getColumn(1).setCellRenderer(dt);
	            tm.getColumn(2).setCellRenderer(dt);
	            tm.getColumn(3).setCellRenderer(dt);
	            tm.getColumn(4).setCellRenderer(dt);
	            
	            tm.getColumn(0).setPreferredWidth(70);
	            tm.getColumn(1).setPreferredWidth(70);
	            tm.getColumn(2).setPreferredWidth(70);
	            tm.getColumn(3).setPreferredWidth(70);
	            tm.getColumn(4).setPreferredWidth(70);
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( stmt != null && !stmt.isClosed()){
	                    stmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	 public  void scenario() {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        String id,pw=null;
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            // 3. 쿼리 수행을 위한 Statement 객체 생성
	            stmt = conn.createStatement();
	            String sql = "SELECT title,contents FROM scenarios";

	            // 5. 쿼리 수행
	            // 레코드들은 ResultSet 객체에 추가된다.
	            rs = stmt.executeQuery(sql);
	           
	            //Info.password=null;
	            // 6. 실행결과 출력하기
	            int i=0;
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                id= rs.getString(1);
	                pw= rs.getString(2);
	                scenarios[i]=id;
	                
	                         i++;
	            }
	            i=0;
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( stmt != null && !stmt.isClosed()){
	                    stmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 public  void scenariosearch(String title) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        String id,pw=null;
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            // 3. 쿼리 수행을 위한 Statement 객체 생성
	            stmt = conn.createStatement();
	            String sql = "SELECT contents FROM scenarios where title='" + title + "'";

	            // 5. 쿼리 수행
	            // 레코드들은 ResultSet 객체에 추가된다.
	            rs = stmt.executeQuery(sql);
	           
	            //Info.password=null;
	            // 6. 실행결과 출력하기
	            int i=0;
	            if(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                id= rs.getString(1);
	                mysql=id;
	               
	            }
	           
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( stmt != null && !stmt.isClosed()){
	                    stmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 public  void sqlsearch(String sql1) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	       
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            // 3. 쿼리 수행을 위한 Statement 객체 생성
	            stmt = conn.createStatement();
	            String sql = sql1;

	            // 5. 쿼리 수행
	            // 레코드들은 ResultSet 객체에 추가된다.
	            rs = stmt.executeQuery(sql);
	            ResultSetMetaData rsmd = rs.getMetaData();
	            //Info.password=null;
	            // 6. 실행결과 출력하기
	            int i=0;
	           // int j=0;
	            Typetester test = new Typetester();
            	ScenarioBoard s= new ScenarioBoard();
            	s.data=new String[800][5];
            	s.headings=new String[5];
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	            	
	            	int columncount=rsmd.getColumnCount();
	            	for(int k=0; k<columncount; k++)
	            	{
	            		s.headings[k]=rsmd.getColumnName(k+1);
	            		String first= test.printType(rs.getString(k+1));
	            		s.data[i][k]=first;
	            	}
	            	
	            
	             i++;
	                
	            }
	           
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( stmt != null && !stmt.isClosed()){
	                    stmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	 public  void search(String title) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        String id,pw=null;
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            // 3. 쿼리 수행을 위한 Statement 객체 생성
	            stmt = conn.createStatement();
	            String sql = "SELECT * FROM bulletin where title = '" + title + "' or author = '" + title +"' or date= '" + title + "'";

	            // 5. 쿼리 수행
	            // 레코드들은 ResultSet 객체에 추가된다.
	            rs = stmt.executeQuery(sql);
	           
	            //Info.password=null;
	            // 6. 실행결과 출력하기
	      
	            int i=0;
	            int j=0;
	            BulletinBoard s= new BulletinBoard();
	            s.data= new String [10][4];
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                int num= rs.getInt(1);
	                String title1=rs.getString(2);
	                String author=rs.getString(3);
	                String date=rs.getString(4);
	                
	                
	              
	                	s.data[i][j]=Integer.toString(num);
	                
	                	j++;
	                	
	                	s.data[i][j]=title1;
	                
	                	j++;
	                	s.data[i][j]=author;
	                	
	                	j++;
	                	s.data[i][j]=date;
	                
	                	
	                	i++;
	                	j=0;
	                	
	        }
	           
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( stmt != null && !stmt.isClosed()){
	                    stmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	 
	
	 public  void checklist(String id){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;

	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);      
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();      
	            String sql = sb.append("SELECT id FROM user WHERE id= "+ "'" + id +"'")
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);

	            if(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                String id2= rs.getString(1);            
	                System.out.println(id2);
	                redunCheck = 0;
	            }
	            else
	            {
	            	
	            	redunCheck = 1;
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	
	 public  void quiz(String id){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	       
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);       
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();      
	            String sql = sb.append("SELECT north,south FROM dictionary WHERE south= "+ "'" + id +"'" + "or north= '" + id + "'")
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);

	            if(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                String id2= rs.getString(1);
	                String id3= rs.getString(2);
	                if(id2.equals(id))
	                {
	                	
	                	result=id3;
	                }
	                else if(id3.equals(id))
	                {
	             
	                result=id2;
	                }
	            }
	            else
	            {
	            
	            	result="no match";
	            	
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }

	 public  void quizselect(){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	       
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);      
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();      
	            String sql = sb.append("SELECT north,south FROM dictionary")
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);
	            int i=0;
	            
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                words[i]= rs.getString(1);
	                
	                
	                i++;
	                
	            }
	            i=0;
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	
	 public  void bulletin(){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	       
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);      
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();      
	            String sql = sb.append("SELECT * FROM bulletin")
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);
	            int i=0;
	            int j=0;
	            int n=0;
	            BulletinBoard s= new BulletinBoard();
	            
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                int num= n++;
	                String title=rs.getString(2);
	                String author=rs.getString(3);
	                int date=rs.getInt(4);
	                
	                
	              
	                	s.data[i][j]=Integer.toString(n);
	                	j++;
	                	s.data[i][j]=title;
	                	j++;
	                	s.data[i][j]=author;
	                	j++;
	                	s.data[i][j]=Integer.toString(date);
	                	j=0;
	                    i++;
	            }
	            i=0;
	            j=0;
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	 public  void comment(String title1){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	       
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);      
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();      
	            String sql = sb.append("SELECT * FROM comment where title= '" +title1 +"'")
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);
	            int i=0;
	            int j=0;
	            Posttest s= new Posttest();
	            s.data= new String [8][4];
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                
	                String comment=rs.getString(2);
	                String author=rs.getString(3);
	                String date=rs.getString(4);
	                String title=rs.getString(5);
	                
	              
	                	s.data[i][j]=comment;
	                	j++;
	                	s.data[i][j]=author;
	                	j++;
	                	s.data[i][j]=date;
	                	j++;
	                	s.data[i][j]=title;
	                	j=0;
	                    i++;
	            }
	            i=0;
	            j=0;
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }

	 public  void text(String title1){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	       
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);       
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();      
	            String sql = sb.append("SELECT * FROM bulletin where title= '" +title1 +"'")
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);
	            int i=0;
	            int j=0;
	            Posttest s= new Posttest();
	            
	            if(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                
	                String title2=rs.getString(2);
	                String author=rs.getString(3);
	                //String date=rs.getString(4);
	                String contents2=rs.getString(5);
	                
	              s.title=title2;
	              s.writer=author;
	              s.contents=contents2;
	                	
	            }
	           
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 public void LoginCheck(String id,String pw){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;

	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);
	            stmt = conn.createStatement();
	            StringBuilder sb = new StringBuilder();
     
	            String sql = sb.append("SELECT id,password FROM user WHERE (id,password) in (select id,password from user where id='" +id +"') and password ='" +pw +"'" )
	                    .append(";")
	                    .toString();

	            rs = stmt.executeQuery(sql);


	            // 4. 데이터 binding
	            //pstmt.setString(1, id);
	            //pstmt.setString(2, pw);
	            if(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                String id2= rs.getString(1);
	                String pw2=rs.getString(2);
	              
	                loginid=id2;
	                loginCheck=1;
	              
	            }
	            else
	            {
	            
	            	loginCheck=0;
	            }
	           
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	
	 public void insert(String id, String pw, String name, String cl){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);
	            stmt = conn.createStatement();
	            
	            String sql2 = "SELECT id, password FROM user";
	            rs = stmt.executeQuery(sql2);
	        	int i=0;
	            // 4. 데이터 binding
	        	while(rs.next())
	        	{
	        		i++;
	        	}
	            
	            String sql = "INSERT INTO user(name,id,password,class) VALUES (?,?,?,?)";
	            pstmt = conn.prepareStatement(sql);
	           
//	            pstmt.setInt(1, i+1);
	            pstmt.setString(1, name);
	            pstmt.setString(2, id);
	            pstmt.setString(3, pw);
	            pstmt.setString(4, cl);
	
	            int count = pstmt.executeUpdate();
	            if( count == 0 ){
	                System.out.println("데이터 입력 실패");
	            }
	            else{
	                System.out.println("데이터 입력 성공");
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	 public void reply(String comment, String author, String date, String title){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);
	          
	            
	         
	            String sql = "INSERT INTO comment(comment,author,date,title) values (?,?,?,?)";
	            pstmt = conn.prepareStatement(sql);
	            System.out.println(comment);
	            System.out.println(author);
	            System.out.println(date);
	            System.out.println(title);
	           
//	            pstmt.setInt(1, i+1);
	            pstmt.setString(1, comment);
	            pstmt.setString(2, author);
	            pstmt.setString(3, date);
	            pstmt.setString(4, title);
	
	            int count = pstmt.executeUpdate();
	            if( count == 0 ){
	                System.out.println("데이터 입력 실패");
	            }
	            else{
	                System.out.println("데이터 입력 성공");
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
		
	 public void write(String title, String author, String date, String contents){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        Statement stmt = null;
	        try{
	            // 1. 드라이버 로딩
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);
	            stmt = conn.createStatement();
	            
	            String sql2 = "SELECT id, password FROM user";
	            rs = stmt.executeQuery(sql2);
	        	int i=0;
	            // 4. 데이터 binding
	        	while(rs.next())
	        	{
	        		i++;
	        	}
	            
	            String sql = "INSERT INTO bulletin(title,author,date,contents) VALUES (?,?,?,?)";
	            pstmt = conn.prepareStatement(sql);
	           
//	            pstmt.setInt(1, i+1);
	            pstmt.setString(1, title);
	            pstmt.setString(2, author);
	            pstmt.setString(3, date);
	            pstmt.setString(4, contents);
	
	            int count = pstmt.executeUpdate();
	            if( count == 0 ){
	                System.out.println("데이터 입력 실패");
	            }
	            else{
	                System.out.println("데이터 입력 성공");
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	    }	 
	 
	 public void deletepost(String title){
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        Statement stmt = null;
	        ResultSet rs = null;
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");

	            // 2. 연결하기
	        	String url = rurl;
	            conn = DriverManager.getConnection(url, root, rootpw);

	            StringBuilder sb = new StringBuilder();	         
	            String sql = sb.append("DELETE FROM bulletin WHERE title= "+ "'" + title +"'")
	                    .append(";")
	                    .toString();
	           

	            pstmt = conn.prepareStatement(sql);
	            int count = pstmt.executeUpdate();
	            
	            stmt = conn.createStatement();
	            sql = "SELECT * FROM bulletin where title = '" + title + "' or author = '" + title +"' or date= '" + title + "'";
	            
	            // 5. 쿼리 수행
	            // 레코드들은 ResultSet 객체에 추가된다.
	            rs = stmt.executeQuery(sql);
	            
	            
	            int i=0;
	            int j=0;
	            BulletinBoard s= new BulletinBoard();
	            s.data= new String [10][4];
	            while(rs.next()){
	                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
	                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
	                
	                int num= rs.getInt(1);
	                String title1=rs.getString(2);
	                String author=rs.getString(3);
	                String date=rs.getString(4);
	                
	                
	              
	                	s.data[i][j]=Integer.toString(num);
	              
	                	j++;
	                	
	                	s.data[i][j]=title1;
	                	
	                	j++;
	                	s.data[i][j]=author;
	                
	                	j++;
	                	s.data[i][j]=date;
	                	
	                	
	                	i++;
	                	j=0;
	            }
	            i=0;
	            j=0;
	            if( count == 0 ){
	                System.out.println("데이터 입력 실패");
	            }
	            else{
	                System.out.println("데이터 입력 성공");
	            }
	        }
	        catch( ClassNotFoundException e){
	            System.out.println("드라이버 로딩 실패");
	        }
	        catch( SQLException e){
	            System.out.println("에러 " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( pstmt != null && !pstmt.isClosed()){
	                    pstmt.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
	 }
	 
}
