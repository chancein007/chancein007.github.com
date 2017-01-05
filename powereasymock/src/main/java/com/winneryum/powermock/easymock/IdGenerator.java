package com.winneryum.powermock.easymock;
public class IdGenerator {

  /**
   * @return A new ID based on the current time.
   */
  public static long generateNewId() {
     return System.currentTimeMillis();
  }
}