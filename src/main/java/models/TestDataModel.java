package models;

public class TestDataModel {
    private String username;
    private String email;
    private String address;
    private String password;

    public TestDataModel(String username, String email, String address, String password) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPassword() { return password; }
}
