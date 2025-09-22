package com.javax.movieFlix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(@NotEmpty(message = "streaming name is blank") String name) {
}
