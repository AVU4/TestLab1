package classes;

public class Human {

    private String name;
    private Action action;
    private boolean help;

    public Human(String name) {
        this.name = name;
        this.help = false;
    }

    public Action getAction() {
        return action;
    }

    public boolean setAction(Action action) {
        if (this.action != null && !this.action.isFinished) {
            return false;
        }
        this.action = action;
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean isHelp() {
        return help;
    }

    private void setHelp(boolean help) {
        this.help = help;
    }

    public String helpTo(Human human){
        if (!human.isHelp()) {
            // Персонажу никто не помогает
            if (setAction(new Action("Help"))) {
                // Персонаж не занят другим делом
                human.setHelp(true);
                return "Персонаж начал помогать";
            }
            return "Персонаж не может помочь, занят";
        }else{
            return "Персонажу уже помогают";
        }
    }
}
