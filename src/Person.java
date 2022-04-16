import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    //    Методы, связанные с именем
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    //     Методы, связанные c возрастом
    public boolean hasAge() {
        if (getAge().isPresent())
            return true;
        return false;
    }

    public OptionalInt getAge() {
        if (OptionalInt.of(age).getAsInt() > -1)
            return OptionalInt.of(age);
        else
            return OptionalInt.empty();
    }

    public void happyBirthday() {
        if (getAge().isPresent()) {
            age++;
            System.out.println("С Днём рождения " + name + "! Вам уже " + age);
        } else {
            System.err.println("Необходимо указать возраст");
        }
    }

    //    Методы, связанные c адресом
    public boolean hasAddress() {
        if (this.address == null) return false;
        return true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "{" +
                "Имя: '" + name + '\'' +
                ", Фамилия: '" + surname + '\'' +
                ", Возраст: '" + (getAge().isEmpty() ? "null" : String.valueOf(age)) + '\'' +
                ", Адрес: '" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname);
    }
}