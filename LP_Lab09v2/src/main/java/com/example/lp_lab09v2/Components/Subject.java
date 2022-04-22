package com.example.lp_lab09v2.Components;

public class Subject {
    private int group;
    private String auditorium;
    private String subject;
    private String teacher;
    private String weekDay;

    public Subject(int group, String auditorium, String subject, String teacher, String weekDay) {
        this.group = group;
        this.auditorium = auditorium;
        this.subject = subject;
        this.teacher = teacher;
        this.weekDay = weekDay;
    }

    public int getGroup() {
        return group;
    }
    public String getAuditorium() {
        return auditorium;
    }


    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getWeekDay() {
        return weekDay;
    }


}
