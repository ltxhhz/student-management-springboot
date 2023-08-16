package cn.ltxhhz.springboot_demo.entity;

/**
 * 响应结果生成工具
 */
public class ResultResponse {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";

    public static Result getSuccessResult() {
        return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result getSuccessResult(Object data) {
        return new Result().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static Result getFailResult(String message) {
        return new Result().setCode(ResultCode.FAIL).setMessage(message);
    }

    public static Result getFailResult() {
        return new Result().setCode(ResultCode.FAIL).setMessage(DEFAULT_FAIL_MESSAGE);
    }

    public static Result getResult(boolean success) {
        if (success) {
            return getSuccessResult();
        } else {
            return getFailResult();
        }
    }
}

