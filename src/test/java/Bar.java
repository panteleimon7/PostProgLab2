import java.util.ArrayList;

public class Bar {

    private static ArrayList<Character> list = new ArrayList<>();

    public void growthList() {
        for (int i = 0; i < 1 << 20; i++) {
            list.add('a');
        }
    }

}
