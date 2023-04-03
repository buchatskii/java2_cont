import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private static int count = 1;
    private final int id;
    protected final String firstName;
    protected final String lastname;
    private final String dateOfBirth;
    private final String dateOfDeath;
    private final Sex sex;
    private Human mather;
    private Human father;
    private final List<Human> childrens;


    /**
     * @param firstName   Имя
     * @param lastname    Фамилия
     * @param dateOfBirth дата рождения (Формат записи "ГГГГ-ММ-ДД")
     * @param sex         пол(male or female)
     * @param mather      ссылка на объект мать Human(sex female)
     * @param father      ссылка на объект отец Human(sex male)
     */
    public Human(String firstName, String lastname, String dateOfBirth, Sex sex, Human mather, Human father) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.sex = sex;
        this.mather = mather;
        this.father = father;
        this.childrens = new ArrayList<>();
    }

    public Human(String firstName, String lastname, String dateOfBirth, Sex sex) {
        this.id = count++;
        this.firstName = firstName;
        this.lastname = lastname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.mather = null;
        this.father = null;
        this.childrens = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public int getId() {
        return id;
    }

    public Human getMather() {
        return mather;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    private void setMather(Human mather) {
        this.mather = mather;
    }

    private void setFather(Human father) {
        this.father = father;
    }

    /**Добавить ребенка в лист детей у человека*/
    public void addChildren(Human people) {
        if(!childrens.contains(people)) childrens.add(people);
    }

    @Override
    public String toString() {
        if (dateOfDeath != null) {
            return " %s %s(id %d) \n  Дата рождения - %s' Дата сметри - %s'\n".formatted(firstName, lastname, id, dateOfBirth, dateOfDeath);
        }
        return " %s %s (id %d) \n  Дата рождения - %s \n".formatted(firstName, lastname, id, dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human people = (Human) o;
        return id == people.id && Objects.equals(firstName, people.firstName) && Objects.equals(lastname, people.lastname) && Objects.equals(dateOfBirth, people.dateOfBirth) && Objects.equals(dateOfDeath, people.dateOfDeath) && sex == people.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastname, dateOfBirth, dateOfDeath, sex);
    }
}