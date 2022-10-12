package assignment1.bookmember;

public class BookMember {
    String code;
    String name;
    Integer hours;

    public BookMember(String code, String name, Integer hours) {
        this.code = code;
        this.name = name;
        this.hours = hours;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return getCode()+"-"+getName()+"-"+getHours();
    }
}
