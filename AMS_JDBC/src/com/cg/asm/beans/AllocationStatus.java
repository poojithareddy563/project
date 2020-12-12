package com.cg.asm.beans;

public class AllocationStatus {
	private Integer allocationid;
	private String status;
	public Integer getAllocationid() {
		return allocationid;
	}
	public void setAllocationid(Integer allocationid) {
		this.allocationid = allocationid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "AssetStatus [allocationid=" + allocationid + ", status=" + status + "]";
	}

}
