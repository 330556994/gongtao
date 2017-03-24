package com.gt.bookshop.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 * 会员用户实体类
 */

@Entity
@Table(name="tb_users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user")
//	@SequenceGenerator(name="seq_user",sequenceName="seq_user_id",allocationSize=1,initialValue=1)
    private int id;
	@Column
    private String loginId;
    private String loginPwd ;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String mail;
    @Column
    private Date birthday;
    @Column
    private int userRoleId;
    @Column
    private String registerIp;
    @Column
    private Date registerTime;
    @Column
    private Integer scoreTotal;
    @Column
    private Integer scoreCurrent;
    @Column
    private String headImg;
    @Column
    private int isFrozen;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userRoleId" , insertable = false , updatable = false)
    private UserRoles userRoles;
    
    @OneToMany(mappedBy = "user" , cascade = {CascadeType.ALL})
    private Set<ScoreHistory> scoreHistories;
    
    @OneToMany(mappedBy = "user" , cascade = {CascadeType.ALL})
    private Set<Registration> registrations;
    
    @OneToMany(mappedBy = "user" , cascade = {CascadeType.ALL})
    private Set<ReaderComments> readerComments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public Integer getScoreCurrent() {
        return scoreCurrent;
    }

    public void setScoreCurrent(Integer scoreCurrent) {
        this.scoreCurrent = scoreCurrent;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public int getIsFrozen() {
        return isFrozen;
    }

    public void setIsFrozen(int isFrozen) {
        this.isFrozen = isFrozen;
    }
    
    public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}
    
    public UserRoles getUserRoles() {
		return userRoles;
	}
    
    public void setScoreHistories(Set<ScoreHistory> scoreHistories) {
		this.scoreHistories = scoreHistories;
	}
    
    public Set<ScoreHistory> getScoreHistories() {
		return scoreHistories;
	}
    
    public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}
    
    public Set<Registration> getRegistrations() {
		return registrations;
	}
    
    public void setReaderComments(Set<ReaderComments> readerComments) {
		this.readerComments = readerComments;
	}
    
    public Set<ReaderComments> getReaderComments() {
		return readerComments;
	}
}
