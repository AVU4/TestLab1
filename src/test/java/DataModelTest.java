import classes.Action;
import classes.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.crypto.ArcFourHmac;

public class DataModelTest {

    @Test
    public void testHelp(){
        Human Trillian = new Human("Триллиан");
        Human Arthur = new Human("Артур");
        Assertions.assertFalse(Arthur.isHelp());
        Assertions.assertEquals("Персонаж начал помогать", Trillian.helpTo(Arthur));
        Assertions.assertTrue(Arthur.isHelp());
    }

    @Test
    public void testCanNotHelp(){
        Human Ford = new Human("Форд");
        Human Arthur = new Human("Артур");
        Action action = new Action("Открытие двери");
        Ford.setAction(action);
        Assertions.assertEquals("Открытие двери", Ford.getAction().getNameProcess());
        Assertions.assertFalse(Arthur.isHelp());
        Assertions.assertEquals("Персонаж не может помочь, занят", Ford.helpTo(Arthur));
        Assertions.assertFalse(Arthur.isHelp());
    }
}
