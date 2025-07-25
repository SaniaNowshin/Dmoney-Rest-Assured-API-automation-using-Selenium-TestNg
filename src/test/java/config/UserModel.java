package config;

public class UserModel {
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String nid;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserModel(String name, String email, String password, String phone_number, String nid, String role){
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone_number=phone_number;
        this.nid=nid;
        this.role=role;
    }
    public UserModel(){

    }
}
