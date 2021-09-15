package com.xzsj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 *  druid数据库连接池  抽取工具类
 * @author John
 *
 */
public class JDBCUtils {
	private static DataSource ds; //数据库连接池对象
	static {
		Properties pro = new Properties();
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			pro.load(is); //加载配置文件
			ds = DruidDataSourceFactory.createDataSource(pro); //创建数据库连接池对象
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接池对象
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * 获取连接对象
	 * @throws SQLException 
	 * 
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/**
	 * 归还连接
	 */
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 归还连接（重载方法）
	 */
	public static void close(PreparedStatement pstmt,Connection conn) {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

