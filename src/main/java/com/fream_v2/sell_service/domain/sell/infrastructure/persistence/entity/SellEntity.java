package com.fream_v2.sell_service.infrastructure.persistence.entity;

import com.fream_v2.sell_service.domain.sell.domain.model.Sell;
import com.fream_v2.sell_service.domain.sell.domain.model.SellStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

/**
 * 판매 엔티티 (Infrastructure Layer)
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("sells")
public class SellEntity {
    @Id
    private Long id;
    private Long sellerId;
    private Long productId;
    private Long price;
    private Long minPrice;
    private String description;
    private String status;
    private Integer viewCount;
    private String metadata; // JSON 문자열로 저장
    private LocalDateTime listedAt;
    private LocalDateTime expiresAt;
    private LocalDateTime updatedAt;

    /**
     * 도메인 모델로 변환
     */
    public Sell toDomain() {
        return Sell.builder()
                .sellId(this.id)
                .sellerId(this.sellerId)
                .productId(this.productId)
                .price(this.price)
                .minPrice(this.minPrice)
                .description(this.description)
                .status(SellStatus.valueOf(this.status))
                .viewCount(this.viewCount)
                .metadata(parseMetadata(this.metadata))
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 생성 (신규)
     */
    public static SellEntity fromDomain(Sell sell) {
        return SellEntity.builder()
                .sellerId(sell.getSellerId())
                .productId(sell.getProductId())
                .price(sell.getPrice())
                .minPrice(sell.getMinPrice())
                .description(sell.getDescription())
                .status(sell.getStatus().name())
                .viewCount(sell.getViewCount())
                .metadata(toJsonString(sell.getMetadata()))
                .listedAt(sell.getListedAt())
                .expiresAt(sell.getExpiresAt())
                .updatedAt(sell.getUpdatedAt())
                .build();
    }

    /**
     * 도메인 모델로부터 엔티티 업데이트 (기존 ID 포함)
     */
    public static SellEntity updateFromDomain(Sell sell) {
        return SellEntity.builder()
                .id(sell.getSellId())
                .sellerId(sell.getSellerId())
                .productId(sell.getProductId())
                .price(sell.getPrice())
                .minPrice(sell.getMinPrice())
                .description(sell.getDescription())
                .status(sell.getStatus().name())
                .viewCount(sell.getViewCount())
                .metadata(toJsonString(sell.getMetadata()))
                .listedAt(sell.getListedAt())
                .expiresAt(sell.getExpiresAt())
                .updatedAt(sell.getUpdatedAt())
                .build();
    }

    // Metadata JSON 변환 헬퍼 메서드
    private static String toJsonString(Object metadata) {
        // 실제 구현 시 ObjectMapper 사용
        return metadata != null ? metadata.toString() : null;
    }

    private static java.util.Map<String, Object> parseMetadata(String json) {
        // 실제 구현 시 ObjectMapper 사용
        return json != null ? new java.util.HashMap<>() : null;
    }
}