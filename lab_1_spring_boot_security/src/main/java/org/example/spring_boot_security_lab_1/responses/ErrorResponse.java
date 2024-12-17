package org.example.spring_boot_security_lab_1.responses;

import lombok.Builder;

@Builder
public record ErrorResponse(String message) {
}
