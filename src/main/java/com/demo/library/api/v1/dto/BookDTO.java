package com.demo.library.api.v1.dto;

import java.time.Instant;

public record BookDTO(String id, String title, String description, Instant publishedAt, int numberOfPages) {
}
