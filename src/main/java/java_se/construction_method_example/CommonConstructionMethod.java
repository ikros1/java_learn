package java_se.construction_method_example;

public class CommonConstructionMethod {
    private String name;
    private int age;
    public CommonConstructionMethod(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public CommonConstructionMethod() {
        this("undefined");
    }
    public CommonConstructionMethod(String name){
        this(name,0);
    }
}
