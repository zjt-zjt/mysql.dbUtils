package com.lanou.dbUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ResultSetHandler {

	public static void main(String[] args) throws Exception {
//		bean();
//		bean1();
//		scalar() ;
		//scalar1();
//		scalar2();
		//map();
		maplist();
	}
	//单个的查询 BeanHandler
	public static void bean() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select id sid,num snum,name sname, sex ssex,age sage,professional smajor,number sphone from stu where num = ?";
		Student student = qr.query(sql, new BeanHandler<Student>(Student.class), 37);
		System.out.println(student);
	}
	
	//多个的查询BeanListHandler
	public static void bean1() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select id sid,num snum,name sname, sex ssex,age sage,professional smajor,number sphone from stu where num > ?";
		List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class), 20);
		for(Student student:list) {
			System.out.println(student);
		}
	}
	
	//具体的查询，只显示某个人的名字， ScalarHandler
	public static void scalar() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select name sname  from stu where num = ?";
		String name = qr.query(sql, new ScalarHandler<String>(), 37);
		System.out.println(name);
		
	}
	//显示的信息个数 ScalarHandler
	public static void scalar1() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select count(*)  from stu ";
		Object count = qr.query(sql, new ScalarHandler<Object>());
		System.out.println(count);
		
	}
	//显示年龄的最大值 ScalarHandler
	public static void scalar2() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select max(age)  from stu ";
		Object count = qr.query(sql, new ScalarHandler<Object>());
		System.out.println(count);
		
	}
	
	//显示单个人的信息，利用MapHandler()
	public static void map() throws Exception {
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
		String sql = "select id sid,num snum,name sname, sex ssex,age sage,professional smajor,number sphone from stu where num = ?";
		Map<String, Object> map = qr.query(sql, new MapHandler(), 37);
		System.out.println(map);
	}
	
	//显示单个人的信息，利用MapListHandler()
		public static void maplist() throws Exception {
			QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
			String sql = "select id sid,num snum,name sname, sex ssex,age sage,professional smajor,number sphone from stu where num > ?";
			List<Map<String, Object>> map = qr.query(sql, new MapListHandler(), 37);
			for(Map<String, Object> list :map) {
				System.out.println(list);
			}
		}
	
	
}
