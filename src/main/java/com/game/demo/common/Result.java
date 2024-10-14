package com.game.demo.common;

/**
 * The Result class is responsible for returning the outcome of server operations.
 * It encapsulates the response code (0 for success, -1 for error), any accompanying data,
 * and an optional error message if the operation fails.
 */
public class Result {
    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";

    private String code;
    private String message;
    private Object data;

    /**
     * Creates a success Result with no data.
     *
     * @return a Result object indicating success.
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS);
        return result;
    }

    /**
     * Creates an error Result with a specified error message.
     *
     * @param message the error message to include in the Result.
     * @return a Result object indicating an error, with the provided message.
     */
    public static Result error(String message) {
        Result result = new Result();
        result.setCode(ERROR);
        result.setMessage(message);
        return result;
    }

    /**
     * Creates a success Result with the provided data.
     *
     * @param data the data to include in the Result.
     * @return a Result object indicating success, with the provided data.
     */
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS);
        result.setData(data);
        return result;
    }

    // Getters and Setters for the fields

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
