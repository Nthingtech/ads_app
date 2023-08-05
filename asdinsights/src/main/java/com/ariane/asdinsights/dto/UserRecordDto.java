package com.ariane.asdinsights.dto;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String userName,
                            @NotBlank String firstName,
                            @NotBlank String lastName,
                            @NotBlank String userProfile,
                            @NotBlank String password) {
}
