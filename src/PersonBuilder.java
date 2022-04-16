import javax.sound.sampled.UnsupportedAudioFileException;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            System.err.println("Возраст не может быть отрицательным числом");
            throw new IllegalArgumentException();
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null) {
            System.err.println("Необходимо указать имя!");
            throw new IllegalArgumentException();
        } else if (this.surname == null) {
            System.err.println("Необходимо указать фамилию!");
            throw new IllegalArgumentException();
        } else {
            Person person = new Person(this);
            return person;
        }

    }
}