package com.flipkart.cabservice;

import com.flipkart.cabservice.command.BookingEvent;
import com.flipkart.cabservice.command.CabBookingCommand;
import com.flipkart.cabservice.command.CabEndBookingCommand;
import com.flipkart.cabservice.command.CabRegistrationCommand;
import com.flipkart.cabservice.command.EndBookingEvent;
import com.flipkart.cabservice.command.RegisterEvent;

public class MyCabPlatForm {
  private CabManagementService cabManagementService;

  public MyCabPlatForm() {
    this.cabManagementService = new CabManagementService();
  }

  public void registerCab(String driverName, String cabNumber, int phNumber, String city) {
    final CabRegistrationCommand cabRegistrationCommand =
        new CabRegistrationCommand(cabManagementService);
    RegisterEvent cabPersonalDetails = new RegisterEvent(driverName, cabNumber, phNumber, city);
    cabRegistrationCommand.execute(cabPersonalDetails);
  }

  public void bookCab(String userDetails, String source, String dest) {
    final CabBookingCommand cabBookingCommand =
        new CabBookingCommand(cabManagementService);
    BookingEvent bookingEvent = new BookingEvent(userDetails, source, dest);
    cabBookingCommand.execute(bookingEvent);
  }

  public void endCab(String userDetails) {
    final CabEndBookingCommand endBookingCommand =
        new CabEndBookingCommand(cabManagementService);
    EndBookingEvent bookingEvent = new EndBookingEvent(userDetails);
    endBookingCommand.execute(bookingEvent);
  }
}
