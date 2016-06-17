package com.istream.ihr.orm;
// Generated 21-May-2016 13:20:47 by Hibernate Tools 4.3.1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * UserAccount generated by hbm2java
 */
@Entity
@Table(name = "user_account", catalog = "ihr")
public class UserAccount implements java.io.Serializable {

	private Integer userId;
	private Integer employeeID;
	private Role role;
	private String username;
	private Integer clientId;
	private Date creationTs;
	private Date lastUpdateTs;

	public UserAccount() {
	}

	public UserAccount(Role role, String username, Date creationTs, Date lastUpdateTs) {
		this.role = role;
		this.username = username;
		this.creationTs = creationTs;
		this.lastUpdateTs = lastUpdateTs;
	}

	public UserAccount(Integer employeeID, Role role, String username, Integer clientId, Date creationTs,
			Date lastUpdateTs) {
		this.employeeID = employeeID;
		this.role = role;
		this.username = username;
		this.clientId = clientId;
		this.creationTs = creationTs;
		this.lastUpdateTs = lastUpdateTs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "User_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "Emp_id", unique = true, nullable = false)
	public Integer getEmployeeID() {
		return this.employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "Username", nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Client_id")
	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Creation_ts", nullable = false, length = 0)
	public Date getCreationTs() {
		return this.creationTs;
	}

	public void setCreationTs(Date creationTs) {
		this.creationTs = creationTs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Last_update_ts", nullable = false, length = 0)
	public Date getLastUpdateTs() {
		return this.lastUpdateTs;
	}

	public void setLastUpdateTs(Date lastUpdateTs) {
		this.lastUpdateTs = lastUpdateTs;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}