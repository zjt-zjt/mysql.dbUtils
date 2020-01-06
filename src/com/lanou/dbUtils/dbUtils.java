package com.lanou.dbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;


import com.mchange.v2.c3p0.ComboPooledDataSource;

public class dbUtils {

	public static void main(String[] args) throws Exception {
//		query();
		query1();
	}

	//批量的增加删除更改
	public static void batch() throws Exception {
		 QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		 String sql = "insert into stu (id,num,name,sex,age,professional,number)values(?,?,?,?,?,?,?)";
		 Object [][] objects = {{30,66,"张三","男",25,"计算机","12345678911"},
				 {30,66,"张三","男",25,"计算机","12345678911"} };
		      qr.batch(sql, objects);
	}
	
	
	
	
	//利用QueryRunner 的增加删除，更改
	public static void update() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "insert into stu (id,num,name,sex,age,professional,number)value(?,?,?,?,?,?,?)";
		qr.update(sql, 30,66,"张三","男",25,"计算机","12345678911");
		
	}
	//利用QueryRunner 的增加删除，更改，适用与事务
	public static void update1() throws Exception {
		DataSource ds = new ComboPooledDataSource();
		QueryRunner qr = new QueryRunner(ds);
		Connection con = ds.getConnection();
		try{
			con.setAutoCommit(false);//开始事务
			String sql = "delete from stu where num =?";
			qr.update(con,sql, 66);
			int a= 10/0;
			String sql2 = "delete from stu where num =?";
			qr.update(con,sql2, 65);
			con.commit();//关闭事务
		}catch (Exception e) {
			con.rollback();
		}finally{
			con.close();
		}
	
		
	}
	
	//单个的查询，利用利用QueryRunner
	public static void query1() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select*from stu where num = ?";
		ResultSetHandler<Student> rsh = new ResultSetHandler<Student>() {
            
			@Override
			public Student handle(ResultSet rs) throws SQLException {
				   boolean flag = rs.next();
				if(flag==true) {
					 int sid = rs.getInt("id");
					 int snum = rs.getInt("num");
		             String sname = rs.getString("name");
		        	 String ssex = rs.getString("sex");
		        	int sage = rs.getInt("age");
		        	String smajor = rs.getString("professional");
		            String sphone = rs.getString("number");
		        	Student student = new Student( sid,snum, sname, ssex, sage, smajor, sphone);
					return student;
				}
				 return null;
				 
			      }
		};
		    Student student = qr.query(sql, rsh,37);
		    System.out.println(student);
		
	}
			
	//通用的查询 利用QueryRunner
	public static void query() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select*from stu ";
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
		 List<Student>  list = qr.query(sql, rsh);
	      for(Student student:list) {
	    	  System.out.println(student);
		
	}
	
}
	
	
	
	
}
