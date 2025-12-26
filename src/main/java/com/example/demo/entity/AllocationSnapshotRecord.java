package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllocationSnapshotRecord {

    private Long id;
    private String investorId;
    private String snapshotJson;
    private LocalDateTime capturedAt;
}
