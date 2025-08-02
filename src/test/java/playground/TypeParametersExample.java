package playground;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

class GenericClass<T> {
	// ...
//	private T item;
//
//	GenericClass(T item) {
//		this.item = item;
//	}
}

public class TypeParametersExample {

	public static void main(String[] args) {
		Class<GenericClass> clazz = GenericClass.class;
		TypeVariable<Class<GenericClass>>[] typeParameters = clazz.getTypeParameters();

		System.out.println("length parameters of GenericClass: " + typeParameters.length);
	}
}
