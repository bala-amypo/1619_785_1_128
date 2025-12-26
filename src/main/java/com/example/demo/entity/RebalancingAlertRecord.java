package com.example.demo.entity;

import lombok.*;
import java.time.LocalDateTime;
import com.example.demo.entity.enums.AlertSeverity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebalancingAlertRecord {

    private Long id;
    private String investorId;

    private double currentPercentage;  // ✅ REQUIRED
    private double targetPercentage;   // ✅ REQUIRED

    private boolean resolved;           // ✅ REQUIRED

    private String message;
    private AlertSeverity severity;
    private LocalDateTime createdAt;
}
