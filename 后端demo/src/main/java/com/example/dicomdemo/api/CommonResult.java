package com.example.dicomdemo.api;
import com.projectdicom.demo.api.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public class CommonResult<T> implements Serializable {

        /**
         * 是否成功
         **/
        private boolean success;

        /**
         * 返回码
         **/
        private String error_code;

        /**
         * 返回消息
         **/
        private String error_message;

        /**
         * 是返回数据
         **/
        private T data;

        public static <T> CommonResult<T> ok() {
            return new CommonResult<T>()
                    .setSuccess(true);
        }

        public static <T> CommonResult<T> ok(T data) {
            return new CommonResult<T>()
                    .setSuccess(true)
                    .setData(data);
        }

        public static <T> CommonResult<T> fail(ResultCode resultCode) {
            return new CommonResult<T>()
                    .setSuccess(false)
                    .setError_code(resultCode.getError_code())
                    .setError_message(resultCode.getError_message());
        }
        public static <T> CommonResult<T> fail(String error_message) {
            return new CommonResult<T>()
                    .setSuccess(false)
                    .setError_message(error_message);
        }

        public CommonResult<T> append(T data) {
            this.data = data;
            return this;
        }
}
