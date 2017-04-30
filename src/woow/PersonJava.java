package woow;

public class PersonJava {

    private String name;
    private String surname;
    private int age;

    PersonJava(String name, String surname, int age) {
        this.setName(name);
        this.setSurname(surname);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
