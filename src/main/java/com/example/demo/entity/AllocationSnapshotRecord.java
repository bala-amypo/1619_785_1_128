package com.example.demo.entity;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllocationSnapshotRecord {

    private Long id;
    private String investorId;
    private String snapshotJson;
    private LocalDateTime capturedAt;   // ✅ FIXED TYPE
}
