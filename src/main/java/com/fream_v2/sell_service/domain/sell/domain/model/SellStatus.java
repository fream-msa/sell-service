package com.fream_v2.sell_service.domain.sell.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 판매 상태 값 객체
 */
@Getter
@RequiredArgsConstructor
public enum SellStatus {
    PENDING("대기", "판매 대기 중"),
    MATCHED("매칭됨", "구매자와 매칭 완료"),
    RESERVED("예약됨", "구매자가 결제 진행 중"),
    SOLD("판매완료", "거래 완료"),
    CANCELLED("취소됨", "판매 취소"),
    EXPIRED("만료됨", "판매 기간 만료");

    private final String name;
    private final String description;

    /**
     * 취소 가능 상태 확인
     */
    public boolean isCancellable() {
        return this == PENDING || this == MATCHED;
    }

    /**
     * 진행 중 상태 확인
     */
    public boolean isInProgress() {
        return this == PENDING || this == MATCHED || this == RESERVED;
    }

    /**
     * 종료 상태 확인
     */
    public boolean isFinished() {
        return this == SOLD || this == CANCELLED || this == EXPIRED;
    }
}