package com.yhh.dao.impl;

import java.sql.Connection;


import com.yhh.pojo.Image;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.yhh.dao.ImageDao;
import com.yhh.pojo.Image;

public class ImageDaoImpl implements ImageDao{
	@Override
	public int addImageDao(Image img) {
		Connection conn=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		
		int index=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
			String sql="insert into t_image (id,name,country,position,resolution,longitude,latitude,acquisition_time,scale)\r\n" + 
					" VALUES (default,?,?,?,?,?,?,?,?);";
			ps= conn.prepareStatement(sql);
			ps.setString(1, img.getName());
			ps.setString(2, img.getCountry());
			ps.setString(3, img.getPosition());
			ps.setString(4, img.getResolution());
			ps.setString(5, img.getLongitude());
			ps.setString(6, img.getLatitude());
			ps.setString(7, img.getAcquisition_time());
			ps.setString(8, img.getScale());
			index=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	
		return 0;
	}
	
	
	@Override
	public List<Image> watchImageDao(Image img){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Image> li=null;
		int index=-1;
		int flag=0;
		int count=0;
		String table_name="t_image";
		String sql=table_name;
		String[] paramater= {img.getCountry(),img.getName(),img.getPosition(),
				img.getResolution(),img.getLongitude(),img.getLatitude(),
				img.getAcquisition_time(),img.getScale()
				};
		boolean[] empty=new boolean[8];
		for(int i=0;i<8;i++)
			empty[i]=true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
			
			if(img.getCountry()!="") {
				sql="select* from "+table_name+" where country=?";
				empty[0]=false;
				flag=1;
				count++;
			}
			if(img.getName()!="") {
				if(flag==0) 
				 sql="select* from "+table_name +" where name=?";
				else
					sql="select* from" + "(" + sql + ")subset_name" + " where name=?";
				empty[1]=false;
				flag=1;
				count++;
			}
			if(img.getPosition()!="") {	
				if(flag==0) 
					 sql="select* from "+table_name +" where position=?";
				else
					sql="select* from" +"(" + sql + ")subset_position" + " where position=?";
				empty[2]=false;
				flag=1;
				count++;
			}
			if(img.getResolution()!="") {
				if(flag==0) 
					sql="select* from "+table_name +" where resolution=?";
				else
					sql="select* from" +"(" + sql + ")subset_resolution" + " where resolution=?";
				empty[3]=false;
				flag=1;
				count++;
			}
			if(img.getLongitude()!="") {
				if(flag==0) 
					sql="select* from "+table_name +" where longitude=?";
				else
					sql="select* from" +"(" + sql + ")subset_longitude" + " where longitude=?";
				empty[4]=false;
				flag=1;
				count++;
			}
			if(img.getLatitude()!="") {
				if(flag==0) 
					sql="select* from "+table_name +" where latitude=?";
				else
					sql="select* from" +"(" + sql + ")subset_latitude" + " where latitude=?";
				empty[5]=false;
				flag=1;
				count++;
			}			
			if(img.getAcquisition_time()!="") {
				if(flag==0) 
					sql="select* from "+table_name +" where acquisition_time=?";
				else
					sql="select* from" +"(" + sql + ")subset_acquisition_time" + " where acquisition_time=?";
				empty[6]=false;
				flag=1;
				count++;
			}	
			if(img.getScale()!="") {
				if(flag==0) 
					sql="select* from "+table_name +" where scale=?";
				else
					sql="select* from" +"(" + sql + ")subset_scale" + " where scale=?";
				empty[7]=false;
				flag=1;
				count++;
			}	
			//System.out.println(count);
			if(count==0){
				//System.out.println("count=0!!!");
				sql="select* from "+table_name;
			}
			ps=conn.prepareStatement(sql);
			for(int i=0;i<count;i++) {
				for(int j=0;j<8;j++) {
					if(!empty[j]) {
						ps.setString(i+1, paramater[j]);
						empty[j]=true;
						break;
					}
				}
			}
	
			rs=ps.executeQuery();
			li=new ArrayList<>();
			while(rs.next()) {
				Image i=new Image();
				i.setCountry(rs.getString("country"));
				i.setName(rs.getString("name"));
				i.setPosition(rs.getString("position"));
				i.setResolution(rs.getString("resolution"));
				i.setLongitude(rs.getString("longitude"));
				i.setLatitude(rs.getString("latitude"));
				i.setAcquisition_time(rs.getString("acquisition_time"));
				i.setScale(rs.getString("scale"));
				li.add(i);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 
		return li;
		
	}
	
	@Override
	public int deleteImageDao(String acquisition_time) {
		
				Connection conn=null;
				PreparedStatement ps=null;
				int index=-1;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
					String sql="DELETE FROM t_image WHERE acquisition_time=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, acquisition_time);
					index=ps.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				return index;
	}
	
	public int updateImageDao(Image img) {
		Connection conn=null;
		PreparedStatement ps=null;
		int index=-1;
		String table_name="t_image";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
			String sql="UPDATE " + table_name+
					" SET country=?,position=?,resolution=?,longitude=?,latitude=?,scale=?" + 
					" WHERE acquisition_time=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, img.getCountry());
			ps.setString(2, img.getPosition());
			ps.setString(3, img.getResolution());
			ps.setString(4, img.getLongitude());
			ps.setString(5, img.getLatitude());
			ps.setString(6, img.getScale());
			ps.setString(7, img.getAcquisition_time());
			index=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return index;
		
	}



}
