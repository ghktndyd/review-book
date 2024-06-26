package com.rebook.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {

    NOT_FOUND_BOOK_ID("NOT_FOUND", "요청하신 책은 존재하지 않습니다."),
    INVALID_REVIEW_DATA(" INVALID_REVIEW_DATA ", "리뷰입력 값이 유효하지 않습니다."),
    NOT_FOUND_REVIEW_ID("NOT_FOUND", "요청하신 리뷰가 존재하지 않습니다."),
    NOT_FOUND_HASHTAG_ID("NOT_FOUND", "요청하신 해쉬태그는 존재하지 않습니다."),
    ;

    private final String code;
    private final String message;
}
