package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe MuseumService.
 */
@Service
public class MuseumService implements MuseumServiceInterface {
  private final MuseumFakeDatabase museumFakeDatabase;

  @Autowired
  public MuseumService(MuseumFakeDatabase museumFakeDatabase) {
    this.museumFakeDatabase = museumFakeDatabase;
  }

  /**
   * Método createMuseum.
  */
  @Override
  public Museum createMuseum(Museum museum) {
    if (!CoordinateUtil.isCoordinateValid(museum.getCoordinate())) {
      throw new InvalidCoordinateException("Invalid coordinates");
    }
    return museumFakeDatabase.saveMuseum(museum);
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    if (!CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException("Invalid coordinates");
    } else {
      return museumFakeDatabase.getClosestMuseum(coordinate, maxDistance)
              .orElseThrow(() -> new MuseumNotFoundException("No museum found"));
    }
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
