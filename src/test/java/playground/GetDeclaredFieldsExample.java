package playground;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

class MyClass {
    public String publicField = "Public";
    private int privateField = 10;
    protected double protectedField = 3.14;
    static boolean staticField = true;
    final String finalField = "Constant";
}

public class GetDeclaredFieldsExample {

    public static void main(String[] args) {
        Class<?> clazz = MyClass.class;

        // Get all declared fields (including private, protected, and default access)
        Field[] declaredFields = clazz.getDeclaredFields();

        System.out.println("Declared fields of MyClass:");
        for (Field field : declaredFields) {
            System.out.println("  - Name: " + field.getName());
            System.out.println("    Type: " + field.getType().getSimpleName());
            System.out.println("    Modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("    Accessible: " + field.isAccessible()); //Initial state is false.
        }

        // Example of accessing a private field (requires setting accessible to true)
        try {
            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true); // Make the field accessible
            int value = (int) privateField.get(new MyClass()); //Get the value of the field.
            System.out.println("\nValue of privateField: " + value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //Example of getFields() vs getDeclaredFields()
        Field[] publicFields = clazz.getFields();
        System.out.println("\nPublic fields of MyClass (getFields()): " + Arrays.toString(publicFields));
    }
}
