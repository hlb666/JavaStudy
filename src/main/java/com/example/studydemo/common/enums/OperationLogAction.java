package com.example.studydemo.common.enums;

/**
 * 业务操作类型
 * 
 * @author ruoyi
 */
public enum OperationLogAction
{
    LOGIN("login"),
    SELECT("query"),
    ADD("add"),
    UPDATE("modify"),
    DELETE("delete"),
    CHECK("check"),
    EXPORT("export"),
    PREVIEW("preview"),
    SYNC("sync"),
    MOUNT("mount"),
    UNMOUNT("unmount"),
    COUNT("count"),
    UPLOAD("upload"),
    DOWNLOAD("download");

    private String action;

    OperationLogAction(String action) {
        this.action = action;
    }

    OperationLogAction() {

    }

    public String getAction() {
        return this.action;
    }
}
