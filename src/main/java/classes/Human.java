package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;

public class Human extends Entity{

    @Getter
    private Action currentAction;

    public Human(String name){
        super(name);
    }

    @Override
    public boolean addAction(Action action) {
        if (this.currentAction == null) {
            this.currentAction = action;
            if (action.getNewCondition() != null) addCondition(action);
            if (action.getResolveCondition() != null) resolvedCondition(action);
            return true;
        } else
            return false;
    }

    @Override
    protected boolean resolvedCondition(Action action) {
        if (action.getTarget().getConditions().contains(action.getResolveCondition())){
            return action.getTarget().getConditions().remove(action.getResolveCondition());
        }else{
            return false;
        }
    }

    @Override
    protected boolean addCondition(Action action) {
        return action.getTarget().getConditions().add(action.getNewCondition());
    }
}
