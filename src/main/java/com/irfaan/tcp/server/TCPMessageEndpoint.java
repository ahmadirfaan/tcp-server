
package com.irfaan.tcp.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import java.io.IOException;

@Slf4j
@MessageEndpoint
public class TCPMessageEndpoint {

 private final MessageService messageService;

 public TCPMessageEndpoint(MessageService messageService) {
  this.messageService = messageService;
 }

 @ServiceActivator(inputChannel = TCPServerConfiguration.TCP_DEFAULT_CHANNEL)
 public byte[] process(byte[] message) throws IOException {
  String response = messageService.process(message);
  log.info("Send message to client");
  return response.getBytes();
 }

}