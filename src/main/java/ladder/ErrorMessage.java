package ladder;

public enum ErrorMessage {
    PERSON_NUM_IS_NOT_VALID("게임의 참여자 수는 1명 이상이어야 합니다."),
    DRAW_LINE_POSITION_IS_NOT_VALID("라인 생성이 불가능한 위치 입니다."),
    POSITION_IS_NOT_VALID("유효하지 않은 위치 입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
