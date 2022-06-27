package Models;

import java.sql.Date;

public class Claim {

	private int claimid;
	private String username;
	private String serialno;
	private Date dateofclaim;
	private String descriptions;
	private int approvalstatus;
	
	public int getClaimId() {
		return claimid;
	}	
	
	public void setClaimId(int claimid) {
		this.claimid = claimid;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public Date getDateofclaim() {
		return dateofclaim;
	}
	public void setDateofclaim(Date dateofclaim) {
		this.dateofclaim = dateofclaim;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public int getApprovalstatus() {
		return approvalstatus;
	}
	public void setApprovalstatus(int approvalstatus) {
		this.approvalstatus = approvalstatus;
	}
	@Override
	public String toString() {
		return "Claim [claimid=" + claimid + ", username=" + username + ", serialno=" + serialno + ", dateofclaim=" + dateofclaim
				+ ", descriptions=" + descriptions + ", approvalstatus=" + approvalstatus + "]";
	}
}
