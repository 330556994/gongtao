package com.gt.bookshop.entities;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 */

@Entity
@Table(name="tb_scorehistory")
public class ScoreHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_scorehistory")
//	@SequenceGenerator(name="seq_scorehistory",sequenceName="seq_scorehistory_id",allocationSize=1,initialValue=1)
    private int id;
	@Column
    private Date createTime;
	@Column
    private int userId;
	@Column
    private int flag;
	@Column
    private int singleScore;
	@Column
    private String descriptions;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId" , insertable = false , updatable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public int getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(int singleScore) {
        this.singleScore = singleScore;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
