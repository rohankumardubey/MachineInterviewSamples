package com.flipkart.cabservice.command;

import com.flipkart.cabservice.Event;

public interface Command<T> {
  ServiceState execute(T event);
}
