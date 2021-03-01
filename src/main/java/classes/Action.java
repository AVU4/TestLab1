package classes;

import java.util.Objects;

public class Action {

    private String nameProcess;
    boolean isFinished;

    public Action(String nameProcess){
        this.nameProcess = nameProcess;
        this.isFinished = false;
    }

    public String getNameProcess() {
        return nameProcess;
    }

    public void setNameProcess(String nameProcess) {
        this.nameProcess = nameProcess;
    }
}
