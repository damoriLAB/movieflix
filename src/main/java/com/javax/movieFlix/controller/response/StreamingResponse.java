package com.javax.movieFlix.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
