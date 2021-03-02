package classes;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Action {

    private String name;
    private String newCondition;
    private String resolveCondition;
    private Entity target;

    public Action(String name) {
        this.name = name;
    }

    public Action(String name, String newCondition, Entity target){
        this(name);
        this.newCondition = newCondition;
        this.target = target;
    }

    public Action(String name, String newCondition, String resolveCondition, Entity target){
        this(name, newCondition, target);
        this.resolveCondition = resolveCondition;
    }

}
