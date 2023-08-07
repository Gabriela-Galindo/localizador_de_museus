package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Museum Controller.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {
  private final MuseumServiceInterface museumService;

  @Autowired
  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  /**
  * Rota Post.
  */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MuseumDto createMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum museumEntity = ModelDtoConverter.dtoToModel(newMuseum);
    Museum createdMuseum = museumService.createMuseum(museumEntity);
    return ModelDtoConverter.modelToDto(createdMuseum);
  }
}
