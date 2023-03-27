package practica2;

import java.time.LocalDate;
public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public void print(){
        System.out.println("Human: "
        + this.firstName + " "
                +this.lastName + " age:"
                +this.age + " weight:"
                +this.weight + " birth day"
                +this.birthDate + " age*weight:"
        +this.age*this.weight);
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public int getAW(){
        return age * weight;
    }

    public String getFirstName() {
        return firstName;
    }

}
