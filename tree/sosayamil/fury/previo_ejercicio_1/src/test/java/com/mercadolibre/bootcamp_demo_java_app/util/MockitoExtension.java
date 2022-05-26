package com.mercadolibre.bootcamp_demo_java_app.util;

import java.lang.reflect.Parameter;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;

public class MockitoExtension implements TestInstancePostProcessor, ParameterResolver {

	/**
	 * initializes mock objects for all attributes of testInstance object
	 */
	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
		MockitoAnnotations.initMocks(testInstance);
	}

	/**
	 * tells JUnit that our extension may handle this method parameter if it is
	 * annotated with @Mock
	 */
	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
		return parameterContext.getParameter()
				.isAnnotationPresent(Mock.class);
	}

	/**
	 * initializes the mock object for the given parameter
	 */
	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
		return this.getMock(parameterContext.getParameter(), extensionContext);
	}

	private Object getMock(Parameter parameter, ExtensionContext extensionContext) {
		Class<?> mockType = parameter.getType();
		Store mocks = extensionContext.getStore(Namespace.create(MockitoExtension.class, mockType));
		String mockName = this.getMockName(parameter);

		if (mockName != null) {
			return mocks.getOrComputeIfAbsent(mockName, key -> mock(mockType, mockName));
		} else {
			return mocks.getOrComputeIfAbsent(mockType.getCanonicalName(), key -> mock(mockType));
		}
	}

	private String getMockName(Parameter parameter) {
		String explicitMockName = parameter.getAnnotation(Mock.class)
				.name()
				.trim();
		if (!explicitMockName.isEmpty()) {
			return explicitMockName;
		} else if (parameter.isNamePresent()) {
			return parameter.getName();
		}
		return null;
	}

}