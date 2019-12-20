package com.yhh.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yhh.dao.UserDao;
import com.yhh.pojo.User;

public class UserDaoImpl implements UserDao{
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User u=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
			String sql="select * from t_user where uname=? and pwd=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
				while(rs.next()){
					u=new User();
					u.setUid(rs.getInt("uid"));
					u.setUname(rs.getString("uname"));
					u.setPwd(rs.getString("pwd"));
					u.setSex(rs.getString("sex"));
					u.setAge(rs.getInt("age"));
					u.setBirth(rs.getString("birth"));
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
		
		
		return u;
	}
	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int index=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
			String sql="update t_user set pwd=? where uid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
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
	@Override
	public List<User> userShowDao() {
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				List<User> lu=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
					String sql="select * from t_user";
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					lu=new ArrayList<User>();
						while(rs.next()){
							User u=new User();
							u.setUid(rs.getInt("uid"));
							u.setUname(rs.getString("uname"));
							u.setPwd(rs.getString("pwd"));
							u.setSex(rs.getString("sex"));
							u.setAge(rs.getInt("age"));
							u.setBirth(rs.getString("birth"));
							lu.add(u);
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
				
				
				return lu;
	}
	@Override
	public int userRegDao(User u) {
		Connection conn=null;
		PreparedStatement ps=null;
		int index=-1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
			String sql="insert into t_user values(default,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
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
	
	//根据UID获取用户信息
		@Override
		public User checkUidDao(String uid) {
				//声明Jdbc对象
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				//声明数据存储对象
				User u=null;
				try {
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//获取连接对象
					conn=DriverManager.getConnection("jdbc:mysql://database.cb5juqzeessf.us-east-1.rds.amazonaws.com:3306/happy?useUnicode=yes&characterEncoding=UTF-8","root", "mengmeng123");
					//创建Sql命令
					String sql="select * from t_user where uid=?";
					//创建Sql命令对象
					ps=conn.prepareStatement(sql);
					//给占位符赋值
					ps.setString(1, uid);
					//执行
					rs=ps.executeQuery();
					//遍历执行结果
					while(rs.next()){
						u=new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
						u.setSex(rs.getString("sex"));
						u.setAge(rs.getInt("age"));
						u.setBirth(rs.getString("birth"));
					}
					//关闭资源
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//返回
				return u;
		}
	
}
