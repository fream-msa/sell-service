package com.fream_v2.sell_service.domain.sell.domain.exception;

import com.fream_v2.sell_service.global.presentation.exception.ErrorCode;
import com.fream_v2.sell_service.global.presentation.exception.GlobalException;

/**
 * 판매 도메인 예외
 */
public class SellException extends GlobalException {

    public SellException(ErrorCode errorCode) {
        super(errorCode);
    }

    public SellException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public SellException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public SellException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    // ===== 자주 사용되는 예외 생성 정적 팩토리 메서드 =====

    // 조회 관련
    public static SellException notFound() {
        return new SellException(SellErrorCode.SELL_NOT_FOUND);
    }

    public static SellException notFound(Long sellId) {
        return new SellException(SellErrorCode.SELL_ID_NOT_FOUND,
                String.format("판매 정보를 찾을 수 없습니다. ID: %d", sellId));
    }

    // 등록 관련
    public static SellException alreadyOnSale(Long productId) {
        return new SellException(SellErrorCode.ALREADY_ON_SALE,
                String.format("이미 판매 중인 상품입니다. 상품 ID: %d", productId));
    }

    public static SellException invalidPrice(Long price) {
        return new SellException(SellErrorCode.INVALID_SELL_PRICE,
                String.format("판매 가격이 유효하지 않습니다: %d원", price));
    }

    public static SellException priceTooLow(Long price, Long minPrice) {
        return new SellException(SellErrorCode.PRICE_TOO_LOW,
                String.format("판매 가격이 너무 낮습니다. 현재: %d원, 최소: %d원", price, minPrice));
    }

    public static SellException minPriceHigherThanPrice(Long price, Long minPrice) {
        return new SellException(SellErrorCode.MIN_PRICE_HIGHER_THAN_PRICE,
                String.format("최소 가격(%d원)이 판매 가격(%d원)보다 높을 수 없습니다.", minPrice, price));
    }

    // 상태 관련
    public static SellException alreadyMatched(Long sellId) {
        return new SellException(SellErrorCode.ALREADY_MATCHED,
                String.format("이미 구매자와 매칭되었습니다. 판매 ID: %d", sellId));
    }

    public static SellException alreadySold(Long sellId) {
        return new SellException(SellErrorCode.ALREADY_SOLD,
                String.format("이미 판매 완료된 상품입니다. 판매 ID: %d", sellId));
    }

    public static SellException expired(Long sellId) {
        return new SellException(SellErrorCode.SELL_EXPIRED,
                String.format("판매 기간이 만료되었습니다. 판매 ID: %d", sellId));
    }

    public static SellException notMatchable(Long sellId) {
        return new SellException(SellErrorCode.NOT_MATCHABLE,
                String.format("매칭 가능한 상태가 아닙니다. 판매 ID: %d", sellId));
    }

    // 취소 관련
    public static SellException cancelNotAllowed(Long sellId, String reason) {
        return new SellException(SellErrorCode.CANCEL_NOT_ALLOWED,
                String.format("취소할 수 없는 판매입니다. ID: %d, 사유: %s", sellId, reason));
    }

    public static SellException cancelAfterMatch(Long sellId) {
        return new SellException(SellErrorCode.CANCEL_AFTER_MATCH,
                String.format("매칭 후에는 취소할 수 없습니다. 판매 ID: %d", sellId));
    }

    // 판매자 관련
    public static SellException notSeller(Long userId) {
        return new SellException(SellErrorCode.NOT_SELLER,
                String.format("판매자가 아닙니다. 사용자 ID: %d", userId));
    }

    public static SellException sellerSuspended(Long userId) {
        return new SellException(SellErrorCode.SELLER_SUSPENDED,
                String.format("판매 권한이 정지된 사용자입니다. ID: %d", userId));
    }

    public static SellException sellerGradeInsufficient(String currentGrade, String requiredGrade) {
        return new SellException(SellErrorCode.SELLER_GRADE_INSUFFICIENT,
                String.format("판매하기 위한 최소 등급을 충족하지 못했습니다. 현재: %s, 필요: %s",
                        currentGrade, requiredGrade));
    }

    // 가격 협상 관련
    public static SellException negotiationNotAllowed() {
        return new SellException(SellErrorCode.NEGOTIATION_NOT_ALLOWED);
    }

    public static SellException priceBelowMinimum(Long proposedPrice, Long minPrice) {
        return new SellException(SellErrorCode.PRICE_BELOW_MINIMUM,
                String.format("제안 가격(%d원)이 최소 가격(%d원)보다 낮습니다.", proposedPrice, minPrice));
    }
}