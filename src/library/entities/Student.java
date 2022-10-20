package library.entities;

public class Student {
    public Integer id;
    public String name;
    public String email;
    public Integer tel;

    public Student(Integer id, String name, String email, Integer tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}
