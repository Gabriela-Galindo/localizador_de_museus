package com.betrybe.museumfinder.solution;

import static org.mockito.Mockito.*;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTypeServiceTest {
  private MuseumFakeDatabase database;
  private CollectionTypeService service;

  @BeforeEach
  public void setUp() {
      database = mock(MuseumFakeDatabase.class);
      service = new CollectionTypeService(database);
  }
  @Test
  public void testCountByCollectionTypes() {
      when(database.countByCollectionType("Type1")).thenReturn(10L);
      CollectionTypeCount result = service.countByCollectionTypes("Type1");
      assertEquals(1, result.collectionTypes().length);
      assertEquals(10L, result.count());
  }
}