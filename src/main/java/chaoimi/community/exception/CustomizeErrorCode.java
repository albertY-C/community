package chaoimi.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中问题或评论进行恢复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYSTEM_ERROR(2004,"服务器冒烟了，要不然你稍后再试试!!!"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"你回复的评论不存在，要不换个试试？"),
    CONTENT_IS_EMPTY(2007,"输入的内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"读错信息啦！！！"),
    NOTIFICATION_NOT_FOUND(2009,"消息不翼而飞了")
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
