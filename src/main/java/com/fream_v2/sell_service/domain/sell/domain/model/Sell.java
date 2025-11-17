package com.fream_v2.sell_service.domain.sell.domain.model;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 판매 도메인 모델 (순수 도메인)
 */
@Getter
@Builder
public class Sell {
    private final Long sellId;
    private final Long sellerId;
    private final Long productId;
    private final Long price;
    private final Long minPrice;
    private final String description;
    private final SellStatus status;
    private final Integer viewCount;
    private final Map<String, Object> metadata;
    private final LocalDateTime listedAt;
    private final LocalDateTime expiresAt;
    private final LocalDateTime updatedAt;

    /**
     * 판매 등록 생성
     */
    public static Sell createSell(Long sellerId, Long productId, Long price,
                                  Long minPrice, String description) {
        return Sell.builder()
                .sellerId(sellerId)
                .productId(productId)
                .price(price)
                .minPrice(minPrice)
                .description(description)
                .status(SellStatus.PENDING)
                .viewCount(0)
                .listedAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusDays(30))
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 가격 수정
     */
    public Sell updatePrice(Long newPrice, Long newMinPrice) {
        return Sell.builder()
                .sellId(this.sellId)
                .sellerId(this.sellerId)
                .productId(this.productId)
                .price(newPrice)
                .minPrice(newMinPrice != null ? newMinPrice : this.minPrice)
                .description(this.description)
                .status(this.status)
                .viewCount(this.viewCount)
                .metadata(this.metadata)
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 상태 변경
     */
    public Sell changeStatus(SellStatus newStatus) {
        return Sell.builder()
                .sellId(this.sellId)
                .sellerId(this.sellerId)
                .productId(this.productId)
                .price(this.price)
                .minPrice(this.minPrice)
                .description(this.description)
                .status(newStatus)
                .viewCount(this.viewCount)
                .metadata(this.metadata)
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    /**
     * 조회수 증가
     */
    public Sell incrementViewCount() {
        return Sell.builder()
                .sellId(this.sellId)
                .sellerId(this.sellerId)
                .productId(this.productId)
                .price(this.price)
                .minPrice(this.minPrice)
                .description(this.description)
                .status(this.status)
                .viewCount(this.viewCount + 1)
                .metadata(this.metadata)
                .listedAt(this.listedAt)
                .expiresAt(this.expiresAt)
                .updatedAt(this.updatedAt)
                .build();
    }

    /**
     * 매칭 가능 여부
     */
    public boolean isMatchable() {
        return this.status == SellStatus.PENDING &&
                this.expiresAt.isAfter(LocalDateTime.now());
    }

    /**
     * 가격 협상 가능 여부
     */
    public boolean isNegotiable() {
        return this.minPrice != null && this.minPrice < this.price;
    }
}