package com.winneryum.powermock.easymock;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistartor {
  private Map serviceRegistrations=new HashMap();
  public long registerService(Object service) {
    final long id = IdGenerator.generateNewId();
    serviceRegistrations.put(id, service);
    return id;
 }
}
