

package code;


@code.MyAnnotation(myAttribute = "Class")
public class TestClass {
    int i;

    public TestClass() {
    }

    public void foo() {
        bar();
    }

    private int bar() {
        (code.TestClass.this.i)++;
        return code.TestClass.this.i;
    }
}

