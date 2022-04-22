package com.example.lp_lab09v2.Components;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class List {
    private final Connection connection;
    ArrayList<Subject> subjects = new ArrayList<>();

    public List(Connection connection) throws SQLException {
        this.connection = connection;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TIMETABLE");
        while (resultSet.next()) {
            {
                subjects.add(new Subject(resultSet.getInt("GROUP_NUM"),
                        resultSet.getString("AUDITORIUM_NUM"),
                        resultSet.getString("SUBJECT_NAME"), resultSet.getString("TEACHER_NAME"),
                        resultSet.getString("WEEK_DAY")));
            }
        }
    }

    public ArrayList<Subject> getList() {
        return subjects;
    }
}
