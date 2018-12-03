package com.utad.kiran.dint_database_task.Qualification;

public class Qualification_Object {
    private String qualifications;
    private String subjects;
    private String dates;
    private String tasks;
    public Qualification_Object(String dates, String subjects, String tasks, String qualifications) {

        this.qualifications = qualifications;
        this.subjects = subjects;
        this.dates = dates;
        this.tasks = tasks;
    }

    public Qualification_Object(Qualification_Object[] information) {

    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
    public void setSubjects(String subjects) { this.subjects = subjects; }
    public void setDates(String dates) {
        this.dates = dates;
    }
    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
    public String getQualifications() {
        return qualifications;
    }

    public String getDates() {
        return dates;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getTasks() {
        return tasks;
    }
}
