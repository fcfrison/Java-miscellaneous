package person;
/**
 * Considering that Java API Persistance won't be used in this section, 
 * the class Person will replace it.
 */
public class Person {
    private int code;
    private String name;

    public Person(int code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [code=" + code + ", name=" + name + "]";
    }

    
}
