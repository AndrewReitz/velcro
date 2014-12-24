package com.andrewreitz.velcro.util;

/** From https://github.com/JakeWharton/u2020 */
public final class Strings {
  private Strings() {
    // No instances.
  }

  /** Checks if the string is blank, like TextUtils.isEmpty() but better */
  public static boolean isBlank(CharSequence string) {
    return (string == null || string.toString().trim().length() == 0);
  }

  /** Checks if a string there, if not returns the default string */
  public static String valueOrDefault(String string, String defaultString) {
    return isBlank(string) ? defaultString : string;
  }

  /** Truncates the string at the length specified */
  public static String truncateAt(String string, int length) {
    return string.length() > length ? string.substring(0, length) : string;
  }

  /** Capitalizes the first letter of the string passed in */
  public static String capitalize(String string) {
    if (isBlank(string)) {
      return "";
    }

    char first = Character.toUpperCase(string.charAt(0));
    return Character.toUpperCase(first) + string.length() > 1 ? string.substring(1) : "";
  }
}
