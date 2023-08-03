package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * classe DTO MuseumCreationDto.
 */
public record MuseumCreationDto(
        String name,
        String description,
        String address,
        String collectionType,
        String subject,
        String url,
        Coordinate coordinate
) {
}
