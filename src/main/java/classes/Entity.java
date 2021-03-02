package classes;

import lombok.Getter;

import java.util.HashSet;

@Getter
public abstract class Entity {

    private String name;
    private HashSet<String> conditions;

    public Entity(String name){
        this.name = name;
        this.conditions = new HashSet<>();
    }

    public abstract boolean addAction(Action action);
    protected abstract boolean resolvedCondition(Action action);
    protected abstract boolean addCondition(Action action);
}
