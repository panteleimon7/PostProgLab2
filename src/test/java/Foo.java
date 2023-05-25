import java.lang.String;
public class Foo {
    private int data;

    public void Increment() {
        data++;
    }

    public Foo(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if  (!(obj instanceof Foo)) return false;
        Foo fooObj = (Foo) obj;
        return fooObj.data == this.data;
    }
}
