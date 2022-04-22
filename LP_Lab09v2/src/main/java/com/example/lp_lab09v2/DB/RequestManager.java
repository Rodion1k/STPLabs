package com.example.lp_lab09v2.DB;

import java.sql.*;

public class RequestManager {
    private final Connection connection;

    public RequestManager(Connection connection) {
        this.connection = connection;
    }
    public void addSubject(int group,String auditorium,String subject,String teacher, String weekDay) throws SQLException {
        PreparedStatement st =connection.prepareStatement("INSERT INTO TIMETABLE (GROUP_NUM,AUDITORIUM_NUM,SUBJECT_NAME,TEACHER_NAME,WEEK_DAY) VALUES (?,?,?,?,?)");
        st.setInt(1,group);
        st.setString(2,auditorium);
        st.setString(3,subject);
        st.setString(4,teacher);
        st.setString(5,weekDay);
        st.executeUpdate();
    }
    public void addUser(String username, String password, String role) throws SQLException {
        PreparedStatement st = connection.prepareStatement("INSERT INTO UsersTable (login, password, Role) VALUES (?, ?, ?)");
        st.setString(1, username);
        st.setInt(2, password.hashCode());
        st.setString(3, role);
        st.executeUpdate();
    }

    public boolean isUser(String username, String password, String role) throws SQLException {
        PreparedStatement st = connection.prepareStatement("SELECT login, password, Role FROM UsersTable WHERE login = ? AND password = ? AND Role = ?");
        st.setString(1, username);
        st.setInt(2, password.hashCode());
        st.setString(3, role);

        ResultSet resultSet = st.executeQuery();
        return resultSet.next();
    }


    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
