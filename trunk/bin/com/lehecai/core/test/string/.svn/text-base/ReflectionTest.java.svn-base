/**
 * 
 */
package com.lehecai.core.test.string;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.lehecai.core.util.CoreObjectUtils;

/**
 * @author Sunshow
 *
 */
public class ReflectionTest {
	
	public void testPublic(String name) {
		System.out.println(String.format("Hi %s, this is a public method.", name));
	}
	
	public void testProtected() {
		System.out.println("This is a protected method.");
	}
	
	public static void main(String[] args) throws Exception {
		PrivateObject privateObject = new PrivateObject("The Private Value");

		Field privateStringField = PrivateObject.class.
		            getDeclaredField("privateString");

		privateStringField.setAccessible(true);

		String fieldValue = (String) privateStringField.get(privateObject);
		System.out.println("fieldValue = " + fieldValue);

		ReflectionTest testObject = new ReflectionTest();
		
		Object[] o = null;
		Method m = CoreObjectUtils.getMethod(ReflectionTest.class, "testPublic", String.class);
		m.invoke(testObject, "Sunshow");
		
		o = null;
		m = CoreObjectUtils.getMethod(ReflectionTest.class, "testProtected");
		m.invoke(testObject, o);
	}
}

class PrivateObject {

	@SuppressWarnings("unused")
	private String privateString = null;

	public PrivateObject(String privateString) {
		this.privateString = privateString;
	}
}
