package com.betrybe.museumfinder.exception;

/**
 * Classe MuseumNotFoundException.
 */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException(String message) {
    super(message);
  }
}