package chapter5.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daoya <daoya@2dfire.com> on 2016/12/12.
 */
public class ResultSupport<T> implements Result<T> {
    private static final long serialVersionUID = 4661096805690919752L;
    private boolean success = true;
    private String resultCode;
    private String message;
    private T model;
    private int totalRecord;
    private List<T> models = new ArrayList();

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getModel() {
        return this.model;
    }

    public int getTotalRecord() {
        return this.totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public ResultSupport() {
    }

    public ResultSupport(boolean success) {
        this.success = success;
    }

    public ResultSupport(boolean success, String resultCode, String message) {
        this.success = success;
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultSupport(String resultCode, String message) {
        this.success = Boolean.FALSE.booleanValue();
        this.resultCode = resultCode;
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getResultCode() {
        return null;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public List<T> getModels() {
        return this.models;
    }

    public void setModels(List<T> models) {
        this.models = models;
    }

    public void setModel(T model) {
        this.model = model;
    }

}

