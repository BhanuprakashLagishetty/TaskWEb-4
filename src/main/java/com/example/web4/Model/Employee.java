package com.example.web4.Model;

public class Employee {
    private String ename;
    private String eid;

    public Employee(String ename, String eid, String edesignation, int esalary) {
        this.ename = ename;
        this.eid = eid;
        this.edesignation = edesignation;
        this.esalary = esalary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEdesignation() {
        return edesignation;
    }

    public void setEdesignation(String edesignation) {
        this.edesignation = edesignation;
    }

    public int getEsalary() {
        return esalary;
    }

    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }

    private String edesignation;
    private int esalary;
}
