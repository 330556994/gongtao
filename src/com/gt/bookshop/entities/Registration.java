package com.gt.bookshop.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 */

@Entity
@Table(name="tb_registration")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_registration")
//	@SequenceGenerator(name="seq_registration",sequenceName="seq_registration_id",allocationSize=1,initialValue=1)
    private int id;
	@Column
    private String content;
	@Column
    private Date registrationTime;
	@Column
    private int userId;
	@Column
    private int flag;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId" , insertable = false , updatable = false)
	private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    public void setUser(User user) {
		this.user = user;
	}
    
    public User getUser() {
		return user;
	}
}
