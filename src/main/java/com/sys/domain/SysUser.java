package com.sys.domain;

import java.io.Serializable;

/**
 * @author peter
 * @version 1.1
 * @date 2019/7/18 10:24
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private String password;
    private Integer userType;
    private Integer agentStoreId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getAgentStoreId() {
        return agentStoreId;
    }

    public void setAgentStoreId(Integer agentStoreId) {
        this.agentStoreId = agentStoreId;
    }
}
