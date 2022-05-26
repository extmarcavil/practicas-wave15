package com.mercadolibre.java_bootcamp_lmaciel_prueba.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Utility class for scope information.
 */
public final class ScopeUtils {

  public static final String SCOPE_SUFFIX = "SCOPE_SUFFIX";

  public static final String ENV_SCOPE = "SCOPE";

  public static final String LOCAL_SCOPE = "local";

  public static final String TEST_SUFFIX = "test";

  public static final String PROD_SUFFIX = "prod";

  private ScopeUtils() {
    // Hide constructor
  }

  public static void calculateScopeSuffix() {
    String[] tokens = StringUtils.split(getScopeValue(), '-');
    System.setProperty(SCOPE_SUFFIX, tokens[tokens.length - 1]);
  }

  public static boolean isLocalScope() {
    return LOCAL_SCOPE.equalsIgnoreCase(getScopeValue());
  }

  public static boolean isTestScope() {
    return getScopeValue()
        .endsWith(TEST_SUFFIX);
  }

  public static boolean isProdScope() {
    return getScopeValue()
        .endsWith(PROD_SUFFIX);
  }

  public static String getScopeValue() {
    String scope = System.getenv(ENV_SCOPE);
    if (StringUtils.isNoneBlank(scope)) {
      return scope;
    }
    return LOCAL_SCOPE;
  }

}
