package com.xzsj.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xzsj.util.JDBCUtils;

public class UserDaoImp implements IUserDao {

	@Override
	public User vaildataLogin(User user) {
		String sql = "SELECT id,NAME,PASSWORD,sex,age,address,phone,user.grant FROM USER "
				+ "WHERE name=? and password=?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setSex(rs.getString("sex"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setGrant(rs.getString("grant"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, pstmt, conn);
		}
		return user;
	}

}
