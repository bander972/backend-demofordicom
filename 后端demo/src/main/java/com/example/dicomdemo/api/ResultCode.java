package com.example.dicomdemo.api;
import lombok.Getter;

@Getter
public enum ResultCode {
    /**
     * 错误码定义
     **/
    BadRequest                  ("400", "请求有误！"),
    Unauthorized                ("401", "用户未登录！"),
    ExpiredToken                ("402", "用户登录状态已过期，请重新登录！"),
    Forbidden                   ("403", "用户无权限！"),
    NotFound                    ("404", "找不到请求地址！"),
    MissingRequestParameter     ("410", "请求参数缺失，请检查接口要求的请求参数是否完整！"),
    RequestMethodNotSupported   ("411", "该接口不支持此请求方法，请检查http请求方法是否正确！"),
    HttpMediaTypeNotSupported   ("412", "该接口不支持此请求数据类型，请检查http请求头的Content-Type字段是否正确！"),
    IllegalIp                   ("413", "恶意请求ip"),
    InternalServerError         ("500", "内部服务器错误！"),
    NullPointerError            ("501", "服务器发生空指针异常！"),
    InsertError                 ("801","新增错误！"),
    UpdateError                 ("802","更新错误！"),
    DeleteError                 ("803","删除失败！"),
    DuplicateKeyError           ("804","更新失败，请检查数据主键是否重复！"),
    DateFoundError              ("805","当前日期下无数据！"),



    //用户模块业务逻辑错误

    UploadImageError            ("01012","上传文件失败");
    private final String error_code;

    private final String error_message;

    ResultCode(String errorCode, String errorMessage) {
        this.error_code = errorCode;
        this.error_message = errorMessage;
    }
}
