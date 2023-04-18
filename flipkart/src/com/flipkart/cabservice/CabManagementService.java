package com.flipkart.cabservice;

import com.flipkart.cabservice.cab.CabPersonalDetails;
import com.flipkart.cabservice.command.ServiceState;

public class CabManagementService {

  public void registerCab(String city, CabPersonalDetails cabPersonalDetails) {

  }

  public void endBooking(String user) {

  }

  public ServiceState bookCab(String user, String source, String dest) {
    return ServiceState.SUCCESS;
  }
}
