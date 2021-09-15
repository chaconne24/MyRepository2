package com.xzsj.Resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xzsj.util.JDBCUtils;
/**
 * 	从数据库获取文件信息
 * @author John
 *
 */
public class ResourceDaoImp implements IResourceDao {
	private ArrayList<Resource> resList = new ArrayList<>();;	
	
	@Override
	public ArrayList<Resource> getResourceList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id,displayname,realName,size,path,TYPE FROM resource;";
			conn = JDBCUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Resource res = null;
			while(rs.next()) {
				res = new Resource(rs.getString("id"),rs.getString("displayname"),rs.getString("realName")
						,rs.getString("size"),rs.getString("path"),rs.getString("TYPE"));
				resList.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, pstmt, conn);
		}
		return resList;
	}

}
