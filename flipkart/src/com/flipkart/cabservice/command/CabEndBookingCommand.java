package com.flipkart.cabservice.command;

import com.flipkart.cabservice.CabManagementService;
import com.flipkart.cabservice.Event;

public class CabEndBookingCommand implements Command<EndBookingEvent>{
  private CabManagementService cabManagementService;
  public CabEndBookingCommand(CabManagementService cabManagementService) {
    this.cabManagementService = cabManagementService;
  }
  @Override public ServiceState execute(EndBookingEvent event) {
    this.cabManagementService.endBooking(event.getUserName());
    return ServiceState.SUCCESS;
  }
}
