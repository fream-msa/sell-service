package com.fream_v2.sell_service.domain.sell.domain.exception;

import com.fream_v2.sell_service.global.presentation.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 판매 도메인 에러 코드
 */
@Getter
@RequiredArgsConstructor
public enum SellErrorCode implements ErrorCode {

    // ===== 판매 조회 관련 (SELL_001 ~ SELL_099) =====
    SELL_NOT_FOUND("SELL_001", "판매 정보를 찾을 수 없습니다.", 404),
    SELL_ID_NOT_FOUND("SELL_002", "해당 ID의 판매 정보를 찾을 수 없습니다.", 404),
    SELLER_NOT_FOUND("SELL_003", "판매자를 찾을 수 없습니다.", 404),
    SELL_DATA_CORRUPTED("SELL_004", "판매 데이터가 손상되었습니다.", 500),

    // ===== 판매 등록 관련 (SELL_100 ~ SELL_199) =====
    PRODUCT_NOT_AVAILABLE("SELL_100", "판매할 수 없는 상품입니다.", 400),
    ALREADY_ON_SALE("SELL_101", "이미 판매 중인 상품입니다.", 409),
    INVALID_SELL_PRICE("SELL_102", "판매 가격이 유효하지 않습니다.", 400),
    PRICE_TOO_LOW("SELL_103", "판매 가격이 너무 낮습니다.", 400),
    PRICE_TOO_HIGH("SELL_104", "판매 가격이 너무 높습니다.", 400),
    MIN_PRICE_HIGHER_THAN_PRICE("SELL_105", "최소 가격이 판매 가격보다 높을 수 없습니다.", 400),
    SELL_REGISTRATION_FAILED("SELL_106", "판매 등록에 실패했습니다.", 500),
    INVALID_EXPIRY_DATE("SELL_107", "유효하지 않은 만료일입니다.", 400),
    SELLER_VERIFICATION_REQUIRED("SELL_108", "판매자 인증이 필요합니다.", 403),
    DAILY_LIMIT_EXCEEDED("SELL_109", "일일 판매 등록 한도를 초과했습니다.", 429),

    // ===== 판매 수정 관련 (SELL_200 ~ SELL_299) =====
    SELL_UPDATE_FAILED("SELL_200", "판매 정보 수정에 실패했습니다.", 500),
    CANNOT_UPDATE_SOLD_ITEM("SELL_201", "판매 완료된 상품은 수정할 수 없습니다.", 400),
    CANNOT_UPDATE_MATCHED_ITEM("SELL_202", "매칭된 상품은 수정할 수 없습니다.", 400),
    PRICE_CHANGE_LIMIT_EXCEEDED("SELL_203", "가격 변경 횟수를 초과했습니다.", 400),
    CANNOT_INCREASE_PRICE("SELL_204", "판매 가격은 인상할 수 없습니다.", 400),
    UPDATE_NOT_ALLOWED("SELL_205", "판매자 본인만 수정할 수 있습니다.", 403),

    // ===== 판매 상태 관련 (SELL_300 ~ SELL_399) =====
    INVALID_SELL_STATUS("SELL_300", "유효하지 않은 판매 상태입니다.", 400),
    ALREADY_MATCHED("SELL_301", "이미 구매자와 매칭되었습니다.", 409),
    ALREADY_RESERVED("SELL_302", "이미 예약된 상품입니다.", 409),
    ALREADY_SOLD("SELL_303", "이미 판매 완료된 상품입니다.", 409),
    ALREADY_CANCELLED("SELL_304", "이미 취소된 판매입니다.", 409),
    SELL_EXPIRED("SELL_305", "판매 기간이 만료되었습니다.", 400),
    NOT_MATCHABLE("SELL_306", "매칭 가능한 상태가 아닙니다.", 400),

    // ===== 판매 취소 관련 (SELL_400 ~ SELL_499) =====
    CANCEL_NOT_ALLOWED("SELL_400", "취소할 수 없는 판매입니다.", 400),
    CANCEL_AFTER_MATCH("SELL_401", "매칭 후에는 취소할 수 없습니다.", 400),
    CANCEL_AFTER_PAYMENT("SELL_402", "결제 완료 후에는 취소할 수 없습니다.", 400),
    CANCEL_TIME_EXPIRED("SELL_403", "취소 가능 시간이 지났습니다.", 400),
    CANCELLATION_FAILED("SELL_404", "판매 취소에 실패했습니다.", 500),

    // ===== 판매자 관련 (SELL_500 ~ SELL_599) =====
    NOT_SELLER("SELL_500", "판매자가 아닙니다.", 403),
    SELLER_SUSPENDED("SELL_501", "판매 권한이 정지된 사용자입니다.", 403),
    SELLER_GRADE_INSUFFICIENT("SELL_502", "판매하기 위한 최소 등급을 충족하지 못했습니다.", 403),
    SELLER_TRUST_SCORE_LOW("SELL_503", "신뢰도가 낮아 판매할 수 없습니다.", 403),

    // ===== 매칭 관련 (SELL_600 ~ SELL_699) =====
    NO_MATCHING_BUYER("SELL_600", "매칭 가능한 구매자가 없습니다.", 404),
    MATCH_FAILED("SELL_601", "구매자 매칭에 실패했습니다.", 500),
    BUYER_CANCELLED("SELL_602", "구매자가 매칭을 취소했습니다.", 400),
    MATCH_EXPIRED("SELL_603", "매칭 유효 시간이 만료되었습니다.", 400),

    // ===== 가격 협상 관련 (SELL_700 ~ SELL_799) =====
    NEGOTIATION_NOT_ALLOWED("SELL_700", "가격 협상이 불가능한 상품입니다.", 400),
    PRICE_BELOW_MINIMUM("SELL_701", "제안 가격이 최소 가격보다 낮습니다.", 400),
    NEGOTIATION_CLOSED("SELL_702", "가격 협상이 종료되었습니다.", 400),
    TOO_MANY_NEGOTIATIONS("SELL_703", "협상 시도 횟수를 초과했습니다.", 429),

    // ===== 검증 관련 (SELL_800 ~ SELL_899) =====
    SELL_DATA_INVALID("SELL_800", "판매 데이터가 유효하지 않습니다.", 400),
    REQUIRED_FIELD_MISSING("SELL_801", "필수 입력 항목이 누락되었습니다.", 400),
    DUPLICATE_SELL("SELL_802", "중복된 판매 등록입니다.", 409),
    DESCRIPTION_TOO_SHORT("SELL_803", "판매 설명이 너무 짧습니다.", 400),
    DESCRIPTION_TOO_LONG("SELL_804", "판매 설명이 너무 깁니다.", 400);

    private final String code;
    private final String message;
    private final int status;
}