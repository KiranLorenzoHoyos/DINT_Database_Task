package com.utad.kiran.dint_database_task.Notification;

public class Notification_Object {
    private String username;
    private String dates;
    private String title;
    public Notification_Object(String dates,  String username, String title) {
        this.username = username;
        this.dates = dates;
        this.title = title;
    }

    public Notification_Object(Notification_Object[] information) {

    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setDates(String dates) {
        this.dates = dates;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUsername() {
        return username;
    }
    public String getDates() {
        return dates;
    }
    public String getTitle() {
        return title;
    }
}
