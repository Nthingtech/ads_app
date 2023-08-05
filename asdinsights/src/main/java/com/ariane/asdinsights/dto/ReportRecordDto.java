package com.ariane.asdinsights.dto;

import com.ariane.asdinsights.models.enums.ChildFeel;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ReportRecordDto(@PastOrPresent(message = "Post date cannot be in the future")
                              LocalDate datePost,
                              Integer dayRating,
                              Integer socialInteraction,
                              Integer anxiety,
                              Integer pleasant,
                              Integer impatience,
                              Integer aggressiveness,
                              Integer friendliness,
                              Integer communication,
                              Integer concentration,
                              ChildFeel emotion) {
}
