
package com.example.gebeya_mood.pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreateUserResponse {

    @SerializedName("__v")
    private Long _V;
    @Expose
    private String _id;
    @SerializedName("date_created")
    private String dateCreated;
    @SerializedName("date_modified")
    private String dateModified;
    @Expose
    private String email;
    @Expose
    private String name;
    @Expose
    private String password;
    @Expose
    private String role;
    @Expose
    private String sex;
    @Expose
    private String team;

    public Long get_V() {
        return _V;
    }

    public void set_V(Long _V) {
        this._V = _V;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}
