package com.javax.movieFlix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "category name is blank") String name) {
}
