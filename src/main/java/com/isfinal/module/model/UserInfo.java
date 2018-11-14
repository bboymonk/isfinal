package com.isfinal.module.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{
    private Integer id;

    private String name;

    private Integer age;

    private String work;

    private String phone;

    private String address;

    private String wechat;

    private String card;

    private String score;

    private String workUnit;

    private String workAddress;

    private String unitPhone;

    private String socialSecurity;

    private String father;

    private String fatherPhone;

    private String mother;

    private String motherPhone;

    private String wife;

    private String wifePhone;

    private String workmate;

    private String workmatePhone;

    private String friend;

    private String friendPhone;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work == null ? null : work.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }

    public String getUnitPhone() {
        return unitPhone;
    }

    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone == null ? null : unitPhone.trim();
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity == null ? null : socialSecurity.trim();
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father == null ? null : father.trim();
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone == null ? null : fatherPhone.trim();
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother == null ? null : mother.trim();
    }

    public String getMotherPhone() {
        return motherPhone;
    }

    public void setMotherPhone(String motherPhone) {
        this.motherPhone = motherPhone == null ? null : motherPhone.trim();
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife == null ? null : wife.trim();
    }

    public String getWifePhone() {
        return wifePhone;
    }

    public void setWifePhone(String wifePhone) {
        this.wifePhone = wifePhone == null ? null : wifePhone.trim();
    }

    public String getWorkmate() {
        return workmate;
    }

    public void setWorkmate(String workmate) {
        this.workmate = workmate == null ? null : workmate.trim();
    }

    public String getWorkmatePhone() {
        return workmatePhone;
    }

    public void setWorkmatePhone(String workmatePhone) {
        this.workmatePhone = workmatePhone == null ? null : workmatePhone.trim();
    }

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend == null ? null : friend.trim();
    }

    public String getFriendPhone() {
        return friendPhone;
    }

    public void setFriendPhone(String friendPhone) {
        this.friendPhone = friendPhone == null ? null : friendPhone.trim();
    }
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}