package com.gt.bookshop.entities;

import java.util.Set;

import javax.persistence.*;

/**
 * Created by GongTao on 2017/2/12/012.
 */

@Entity
@Table(name="tb_userroles")
public class UserRoles {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_userroles")
//	@SequenceGenerator(name="seq_userroles",sequenceName="seq_userroles_id",allocationSize=1,initialValue=1)
    private int id;
	@Column
    private String name;
	@Column
    private Integer maxScore;
	@Column
    private Integer minScore;

	@OneToMany(mappedBy = "userRoles" , cascade = {CascadeType.ALL})
	private Set<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }
    
    public void setUsers(Set<User> users) {
		this.users = users;
	}
    
    public Set<User> getUsers() {
		return users;
	}
}
