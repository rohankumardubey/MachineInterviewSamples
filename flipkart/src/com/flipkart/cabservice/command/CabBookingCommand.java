package com.flipkart.cabservice.command;

import com.flipkart.cabservice.CabManagementService;

public class CabBookingCommand implements Command<BookingEvent> {
  private CabManagementService cabManagementService;
  public CabBookingCommand(CabManagementService cabManagementService) {
    this.cabManagementService = cabManagementService;
  }
  @Override public ServiceState execute(BookingEvent event) {
    return this.cabManagementService
        .bookCab(event.getUserName(), event.getSource(), event.getDest());
  }
}
