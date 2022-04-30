package com.example.cms.Database;

public class CourseInformation {
    int course_id;
    private String nomi;
    private String davomiyligi;
    private String oqituvchi;
    private String narxi;

    public CourseInformation(int course_id, String nomi, String davomiyligi, String oqituvchi, String narxi) {
        this.course_id = course_id;
        this.nomi = nomi;
        this.davomiyligi = davomiyligi;
        this.oqituvchi = oqituvchi;
        this.narxi = narxi;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getNomi() {
        return nomi;
    }

    public void setNomi(String nomi) {
        this.nomi = nomi;
    }

    public String getDavomiyligi() {
        return davomiyligi;
    }

    public void setDavomiyligi(String davomiyligi) {
        this.davomiyligi = davomiyligi;
    }

    public String getOqituvchi() {
        return oqituvchi;
    }

    public void setOqituvchi(String oqituvchi) {
        this.oqituvchi = oqituvchi;
    }

    public String getNarxi() {
        return narxi;
    }

    public void setNarxi(String narxi) {
        this.narxi = narxi;
    }
}
