package com.spothero.grpcjava.server;

public class Config {

  private String key;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return "Config{" + "key='" + key + '\'' + '}';
  }
}
