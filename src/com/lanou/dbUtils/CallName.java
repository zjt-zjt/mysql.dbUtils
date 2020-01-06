package com.lanou.dbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.WrappedPlainView;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class CallName {

	public static void main(String[] args) throws Exception {
		query();

	}

	public static void query() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select*from stu where id =? ";
		String sql1 = "update stu set id =1 where num =? ";
		ResultSetHandler<List<Student>> rsh = new ResultSetHandler<List<Student>>() {
            
			@Override
			public List<Student> handle(ResultSet rs) throws SQLException {
				List<Student> list = new ArrayList<Student>();
				while(rs.next()) {
					int sid = rs.getInt("id");
					int snum = rs.getInt("num");
		            String sname = rs.getString("name");
		        	String ssex = rs.getString("sex");
		        	int sage = rs.getInt("age");
		        	String smajor = rs.getString("professional");
		            String sphone = rs.getString("number");
		        	Student student = new Student( sid,snum, sname, ssex, sage, smajor, sphone);
					list.add(student);
				}
				 return list;
				 
			      }
			     
		};
//		List<Student> list = qr.query(sql, rsh );
//		      int count = 0;
//		    while(count<5) {
//		    	
//			Random random = new Random();
//		      int index = random.nextInt(list.size());
//		      System.out.println(list.get(index) );
//		      list.remove(index);
//		    	 count++;
//		    	
//		  }
		      
		List<Student> list = qr.query(sql, rsh ,0);
		Random random = new Random();
	      int index = random.nextInt(list.size());
	      System.out.println(list.get(index) );
	      //List<Student> list1 = qr.query(sql1, rsh ,list.get(index).getSnum());
	      
		}
		
	
	
	}
	
	
	
	
	
	

	
	

