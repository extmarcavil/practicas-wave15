package com.mercadolibre.bootcamp_demo_java_app.unit;

import com.mercadolibre.bootcamp_demo_java_app.util.ScopeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScopeUtilTest {
	private static void setFinalStatic(Field field, Object newValue) throws IllegalAccessException, NoSuchFieldException {
		field.setAccessible(true);

		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, newValue);
	}

	@Test
	public void testSuffix() throws IllegalAccessException, NoSuchFieldException {
		// Given
		Field field = ScopeUtils.class.getDeclaredField("SCOPE_VALUE");
		setFinalStatic(field, "lalala-integration_test");

		// When
		ScopeUtils.calculateScopeSuffix();

		// Then
		assertEquals("integration_test", System.getProperty(ScopeUtils.SCOPE_SUFFIX));
	}
}