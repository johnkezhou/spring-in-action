package chapter5.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
public interface Result<T> extends Serializable {

    /**
     * 设置请求成功标志。
     *
     * @param success 成功标志
     */
    void setSuccess(boolean success);

    /**
     * 请求是否成功。
     *
     * @return 如果成功，则返回<code>true</code>
     */
    boolean isSuccess();

    /**
     * 当出现业务异常或系统异常时，返回相应的错误码
     *
     * @return 返回码
     */
    String getResultCode();


    /**
     * 设置返回码
     *
     * @param code
     */
    void setResultCode(String code);

    /**
     * 取得model对象
     *
     * @return model对象
     */
    T getModel();

    /**
     * 设置model对象。
     *
     * @param model model对象
     */
    void setModel(T model);

    /**
     * 设置model对象。
     *已废弃，所有对象及列表都置入Model中
     * @param models model对象
     */
    @Deprecated
    void setModels(List<T> models);

    /**
     * 取得所有model对象。
     *
     * @return model对象表
     */
    @Deprecated
    List<T> getModels();

    /**
     * 返回信息
     * @return
     */
    public String getMessage();

    /**
     * 返回错误信息
     * @param message
     */
    public void setMessage(String message);

    /**
     * 如需要总记录数，单独调用接口获取
     * @param totalRecord
     */
    @Deprecated
    public void setTotalRecord(int totalRecord);

    /**
     * * 如需要总记录数，单独调用接口获取
     * 返回记录总数
     * @return
     */
    @Deprecated
    public int getTotalRecord();
}
