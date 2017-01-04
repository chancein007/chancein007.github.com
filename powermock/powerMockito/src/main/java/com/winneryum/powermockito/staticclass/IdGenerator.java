package com.winneryum.powermockito.staticclass;
public class IdGenerator {

  /**
   * @return A new ID based on the current time.
   */
  public static long generateNewId() {
     return System.currentTimeMillis();
  }
}