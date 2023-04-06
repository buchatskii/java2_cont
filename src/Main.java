import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FamilyTree testOne = new FamilyTree();
        Human humanOne = new Human("Максим", "Бикир", "1999-12-29", Sex.male);
        Human humanTwo = new Human("Артур", "Бучацкий", "1970-04-25", Sex.female);
        Human humanThree = new Human("Полина", "Смусина", "1968-03-08", Sex.male);
        Human humanFour = new Human("Артем", "Сумин", "1990-03-24", Sex.female);
        Human humanFive = new Human("Тимур", "Сафаров", "1958-02-15", Sex.female, humanFour, humanThree);

        FamilyTree testTwo = new FamilyTree();

        
        String nameFile = "FamList";
        SerO.saveFile(testOne,nameFile);
        testTwo = SerO.loadFile(nameFile);
        System.out.println(testTwo);




    }
}
