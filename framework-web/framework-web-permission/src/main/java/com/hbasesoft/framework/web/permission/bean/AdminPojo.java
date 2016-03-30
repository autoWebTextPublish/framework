package com.hbasesoft.framework.web.permission.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.hbasesoft.framework.web.core.bean.OperatorPojo;
import com.hbasesoft.framework.db.core.BaseEntity;

@Entity(name = "T_MANAGER_ADMIN")
public class AdminPojo extends BaseEntity {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Transient
    private OperatorPojo operatorPojo;

    /** ADMIN_ID 管理员标识 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADMIN_ID")
    private Integer adminId;

    /** ADMIN_NAME 管理员名称 */
    @Column(name = "ADMIN_NAME")
    private String adminName;

    /** CREATED_TIME 创建日期 */
    @Column(name = "CREATE_TIME")
    private java.util.Date createTime;

    /** STATE 状态 */
    @Column(name = "STATE")
    private String state;

    /** STATE_DATE 状态日期 */
    @Column(name = "STATE_DATE")
    private java.util.Date stateDate;

    /** EMAIL 电子邮件 */
    @Column(name = "EMAIL")
    private String email;

    /** PHONE 电话 */
    @Column(name = "PHONE")
    private String phone;

    /** OPERATOR_ID 操作员标识 */
    @Column(name = "OPERATOR_ID")
    private Integer operatorId;

    /** ADDRESS 地址 */
    @Column(name = "ADDRESS")
    private String address;

    /** HEAD_IMG 头像 */
    @Column(name = "HEAD_IMG")
    private Integer headImg;

    /** GENER 性别 */
    @Column(name = "GENER")
    private String gener;

    @Transient
    private String userName;

    @Transient
    private String accountType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Integer getAdminId() {
        return this.adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return this.adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public java.util.Date getStateDate() {
        return this.stateDate;
    }

    public void setStateDate(java.util.Date stateDate) {
        this.stateDate = stateDate;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Integer headImg) {
        this.headImg = headImg;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public OperatorPojo getOperatorPojo() {
        return operatorPojo;
    }

    public void setOperatorPojo(OperatorPojo operatorPojo) {
        this.operatorPojo = operatorPojo;
    }

}