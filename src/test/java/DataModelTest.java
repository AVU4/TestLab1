import classes.Action;
import classes.Animal;
import classes.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataModelTest {

    @Test
    public void testHelp(){
        Human Trillian = new Human("Триллиан");
        Human Arthur = new Human("Артур");
        Assertions.assertFalse(Arthur.getConditions().contains("saved"));
        Action action = new Action("Помощь", "saved", "confused", Arthur);
        Trillian.addAction(action);
        Assertions.assertNotNull(Trillian.getCurrentAction());
        Assertions.assertTrue(Arthur.getConditions().contains("saved"));
    }

    @Test
    public void testCanNotHelp() {
        Human Ford = new Human("Ford");
        Human Arthur = new Human("Артур");
        Assertions.assertFalse(Arthur.getConditions().contains("saved"));
        Action action = new Action("Открытие двери");
        Ford.addAction(action);
        Assertions.assertNotNull(Ford.getCurrentAction());
        Action help = new Action("Помощь", "saved", "confused", Arthur);
        Assertions.assertFalse(Ford.addAction(help));
        Assertions.assertFalse(Arthur.getConditions().contains("saved"));
    }

    @Test
    public void testAttack(){

        Animal animal = new Animal("Воздухоплавающие грызуны");
        Human Arthur = new Human("Артур");
        Assertions.assertEquals(0, Arthur.getConditions().size());
        Action action = new Action("Атака", "confused", "Feed", Arthur);
        animal.addAction(action);
        Assertions.assertFalse(animal.isHungry());
        Assertions.assertTrue(Arthur.getConditions().contains("confused"));

        Human Trillian = new Human("Триллиан");
        Action help = new Action("Помощь", "saved", "confused", Arthur);
        Trillian.addAction(help);
        Assertions.assertNotNull(Trillian.getCurrentAction());
        Assertions.assertFalse(Arthur.getConditions().contains("confused"));
    }

    @Test
    public void testNotAttack(){
        Animal animal = new Animal("Воздухоплавающие грызуны");
        Human Arthur = new Human("Артур");
        Human Ford = new Human("Форд");
        Action attack = new Action("Атака", "confused", "Feed", Arthur);
        Assertions.assertTrue(animal.isHungry());
        animal.addAction(attack);
        Assertions.assertFalse(animal.isHungry());
        attack = new Action("Атака", "confused", "Feed", Ford);
        animal.addAction(attack);
        Assertions.assertFalse(Ford.getConditions().contains("confused"));
    }
}
