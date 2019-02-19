package com.isfinal;

/**
 * Created by wjb on 2018/7/13.
 */
public class ApasinfoDto {

    private String id;

    private String projNo;

    private String projName;

    private String applyFromName;

    private String xzqh;

    private String xzqhCode;

    private String applyTime;

    private String applyName;
    /**
     * 近5日办件走势日期属性
     */
    private String date;

    /**
     * 申报者证件类型名称
     */
    private String applyCardTypeName;
    /**
     * 申报者提供的有效证件的识别号。如身份证号码：340102198805059786
     */
    private String applyCardNumber;
    /**
     * 办件状态编码
     */
    private String handleStateCode;
    /**
     * 办件状态名称
     */
    private String handleStateName;
    /**
     * 实施部门
     */
    private String receiveDeptName;

    private String count;
    /**
     * 事项名称
     */
    private String projectName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjNo() {
        return projNo;
    }

    public void setProjNo(String projNo) {
        this.projNo = projNo;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getApplyFromName() {
        return applyFromName;
    }

    public void setApplyFromName(String applyFromName) {
        this.applyFromName = applyFromName;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getXzqhCode() {
        return xzqhCode;
    }

    public void setXzqhCode(String xzqhCode) {
        this.xzqhCode = xzqhCode;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getApplyCardTypeName() {
        return applyCardTypeName;
    }

    public void setApplyCardTypeName(String applyCardTypeName) {
        this.applyCardTypeName = applyCardTypeName;
    }

    public String getApplyCardNumber() {
        return applyCardNumber;
    }

    public void setApplyCardNumber(String applyCardNumber) {
        this.applyCardNumber = applyCardNumber;
    }

    public String getHandleStateCode() {
        return handleStateCode;
    }

    public void setHandleStateCode(String handleStateCode) {
        this.handleStateCode = handleStateCode;
    }

    public String getHandleStateName() {
        return handleStateName;
    }

    public void setHandleStateName(String handleStateName) {
        this.handleStateName = handleStateName;
    }

    public String getReceiveDeptName() {
        return receiveDeptName;
    }

    public void setReceiveDeptName(String receiveDeptName) {
        this.receiveDeptName = receiveDeptName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
