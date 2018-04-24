package com.singlePoint.dao;

import com.singlePoint.pojo.MemberSession;
import com.singlePoint.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 */
public class UserDao {
    private DbUtils dbUtils = DbUtils.getInstance();
    public boolean createMemberSession(int userId,String sessionId){
        Connection conn = dbUtils.getConnection();
        String sql = "insert into member_session(user_id,session_id) values(?,?)";
        PreparedStatement stat = null;
        boolean flag = false;
        try {
            conn.setAutoCommit(false);
            stat = conn.prepareStatement(sql);
            stat.setInt(1,userId);
            stat.setString(2,sessionId);
            flag = stat.executeUpdate()>0;
            if(flag){
                conn.commit();// 提交
            }else {
                conn.rollback();// 回滚
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.closeConnection(conn);
        }
        return flag;
    }

    public MemberSession findMemberSessionByUserId(int userId){
        Connection conn = dbUtils.getConnection();
        String sql = "select * from member_session  where user_id=?";
        MemberSession session = null;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                session = new MemberSession();
                session.setUserId(rs.getInt("user_id"));
                session.setSessionId(rs.getString("session_id"));
                session.setStatus(rs.getInt("status"));
                session.setOffLineMsg(rs.getString("off_line_msg"));
                session.setId(rs.getInt("id"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.closeConnection(conn);
        }

        return session;

    }

    public boolean updateMemberSession(MemberSession ms){
        Connection conn = dbUtils.getConnection();
        String sql = "update member_session set session_id=?,off_line_msg=?,status=?,user_id=? where id=?";
        boolean flag = false;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,ms.getSessionId());
            stmt.setString(2,ms.getOffLineMsg());
            stmt.setInt(3,ms.getStatus());
            stmt.setInt(4,ms.getUserId());
            stmt.setInt(5,ms.getId());
            flag = stmt.executeUpdate()>0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.closeConnection(conn);
        }

        return flag;
    }

    public boolean deleteMemberSession(int userId){
        Connection conn = dbUtils.getConnection();
        String sql = "DELETE FROM member_session where user_id=?";
        boolean flag = false;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,userId);
            flag = stmt.executeUpdate()>0;
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.closeConnection(conn);
        }

        return flag;
    }

    public User findUserByLoginName(String userName){
        Connection conn = dbUtils.getConnection();
        String sql = "SELECT * FROM sys_user where username=?";
        PreparedStatement stat = null;
        User user = null;
        try {
            stat = conn.prepareStatement(sql);
            stat.setString(1,userName);
            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(userName);
            }
            rs.close();
            stat.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtils.closeConnection(conn);
        }
        return user;
    }

}
