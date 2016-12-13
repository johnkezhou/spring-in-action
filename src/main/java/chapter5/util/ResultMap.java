package chapter5.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 * 默认 errorCode、message 、record 三个字段将不返回
 * 当code = 0时，errorCode 与 message 和有值返回
 * 当接口返回的是列表，且有记录条数返回时，才返回record记录条数字段
 */
public class ResultMap<T> extends HashMap {
    public static final String CODE = "code";   //接口调用是否成功，0：失败，1：成功
    public static final String ERROR_CODE = "errorCode";   //业务编码 接口调用错误业务编码
    public static final String DATA = "data";       //数据对象 成功需要返回消息，在data里加一个属性（比如：“showMsg”）
    public static final String RECORD = "record";   //记录条数，当查询列表时接口返回的记录条数
    public static final String MESSAGE = "message"; //错误消息内容

    public static final int ERROR = 0;  //异常
    public static final int SUCCESS = 1;//成功


    public ResultMap(T t) {
        put(CODE, SUCCESS);  //初始化默认 为 成功
        if (t instanceof Result) {    //如果传入的是result对象类型，则将result对象转换为ResultMap对象,如还有其他转换对象，可以在下面再加一个else,我们尽量统一远程dubbo接口返回对象为Result
            Result result = (Result) t;
            if (!result.isSuccess()) {  //当接口调用失败时，返回 errorCode、message两个字段
                put(CODE, ERROR);
                put(ERROR_CODE, result.getResultCode());
                put(MESSAGE, result.getMessage());
            }
            if (result.getModel() == null && result.getModels() != null && result.getModels().size() > 0) {  //当返回结果为记录集时，会同时返回总记录数
                put(DATA, result.getModels());
                put(RECORD, result.getTotalRecord());
            } else {  //当返回的只有一个对象时，不需要返回记录条数  record字段
                put(DATA, result.getModel());
            }
        } else if (t instanceof Map) {   //当对象为Map时。属于特殊情况， 不需要放到key为data的属性中，直接copy返回
            putAll((Map) t);
        } else {
            put(DATA, t);
        }
    }

    @Deprecated
    public ResultMap(boolean success, String errorCode, String message) {
        put(CODE, success ? SUCCESS : ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);

    }

    @Deprecated
    public ResultMap(boolean success, String errorCode, String message, T t) {
        this(t);
        put(CODE, success ? SUCCESS : ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);
    }

    @Deprecated
    public ResultMap(boolean success, String errorCode, String message, int record, T t) {
        this(success, errorCode, message, t);
        put(RECORD, record);
    }

    public ResultMap(String errorCode, String message) {
        put(CODE, ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);

    }

    public ResultMap(String errorCode, String message, T t) {
        this(t);
        put(CODE, ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);
    }

    public ResultMap(String errorCode, String message, int record, T t) {
        this(errorCode, message, t);
        put(RECORD, record);
    }

    public ResultMap() {
        put(CODE, SUCCESS);  //初始化默认 为 成功
    }

    public ResultMap(boolean success) {
        put(CODE, success ? SUCCESS : ERROR);
    }

    public void setSuccess(boolean success) {
        put(CODE, success ? SUCCESS : ERROR);
    }

    public void setErrorCode(String errorCode) {
        put(ERROR_CODE, errorCode);
    }

    public void setMessage(String message) {
        put(MESSAGE, message);
    }

    public void setData(T t) {
        put(DATA, t);
    }

}

