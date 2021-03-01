import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    private List<String> history = new ArrayList<>();

    public void sort(int[] num) {
        for (int j = 1; j < num.length; j ++){
            history.add("New element");
            int key = num[j];
            int i = j - 1;
            while (i > -1 && num[i] > key){
                num[i + 1] = num[i];
                i --;
                history.add("Swap");
            }
            if (i == -1) history.add("Left end");
            num[i + 1] = key;
        }
    }

    public List<String> getHistory() {
        return history;
    }

    public void clean() {
        history = new ArrayList<>();
    }
}
