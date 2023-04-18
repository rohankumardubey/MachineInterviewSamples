package com.flipkart.cabservice.command;

import com.flipkart.cabservice.CabManagementService;
import com.flipkart.cabservice.cab.CabPersonalDetails;

public class CabRegistrationCommand implements Command<RegisterEvent> {
  private CabManagementService cabManagementService;

  public CabRegistrationCommand(CabManagementService cabManagementService) {
    this.cabManagementService = cabManagementService;
  }

  @Override public ServiceState execute(RegisterEvent event) {
    CabPersonalDetails cabPersonalDetails =
        new CabPersonalDetails(event.getDriverName(),
            event.getCabNumber(), event.getPhNumber());
    cabManagementService.registerCab(event.getCity(), cabPersonalDetails);
    return ServiceState.SUCCESS;
  }
}
