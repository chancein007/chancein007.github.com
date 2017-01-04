package com.winneryum.powermockito;

public class SingleStaticInstance {
  private static SingleStaticInstance singleStaticInstance = new SingleStaticInstance();
  protected SingleStaticInstance() {
    super();
  }
  static public SingleStaticInstance getCache() {
    return singleStaticInstance;
  }
   
  static public int getID() {
    return 1;
 }

}
