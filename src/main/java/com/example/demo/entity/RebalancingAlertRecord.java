package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import com.example.demo.entity.enums.AlertSeverity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebalancingAlertRecord {

    private Long id;
    private String investorId;
    private String message;
    private AlertSeverity severity;
    private LocalDateTime createdAt;
}
