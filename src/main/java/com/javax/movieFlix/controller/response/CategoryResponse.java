package com.javax.movieFlix.controller.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
