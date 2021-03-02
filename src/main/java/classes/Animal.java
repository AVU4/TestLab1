package classes;

import lombok.Getter;

public class Animal extends Entity {

    @Getter
    private boolean hungry;

    public Animal(String name){
        super(name);
        this.hungry = true;
    }

    @Override
    public boolean addAction(Action action) {
        if (hungry) {
            if (action.getNewCondition() != null) addCondition(action);
            if (action.getResolveCondition() != null) resolvedCondition(action);
            return true;
        }else return false;
    }

    @Override
    protected boolean resolvedCondition(Action action) {
        if (action.getResolveCondition().equals("Feed")) {
            this.hungry = false;
            return true;
        }
        return false;
    }

    @Override
    protected boolean addCondition(Action action) {
        return action.getTarget().getConditions().add(action.getNewCondition());
    }

}
