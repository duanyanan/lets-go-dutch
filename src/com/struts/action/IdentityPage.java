package com.struts.action;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.hbm.dao.*;
import com.hbm.model.*;
import com.opensymphony.xwork2.ActionContext;

public class IdentityPage {
	User pageOwner = new User();
	UserDAO userOperation = new UserDAO();
	Set<Activity> ownedActivity =new HashSet<Activity>();
	 Set<Activity> joinedActivity = new HashSet<Activity>();

	public String showUserInfo() {
		Map<String, Object> httpSession =ActionContext.getContext().getSession();
		pageOwner = userOperation.getUser((String)httpSession.get("login_userID"));	
		ownedActivity = pageOwner.getOwnActivity();
		joinedActivity = pageOwner.getJoinedActivity();
		System.out.println("lalala");
		for(Activity act : ownedActivity)
		{
			System.out.println("lalala");
			System.out.println(act.getName());
			System.out.println(act.getCreateDate());
			System.out.println(act.getEndDate());
		}
		return "success";
	}

	public User getPageOwner() {
		return pageOwner;
	}

	public void setPageOwner(User pageOwner) {
		this.pageOwner = pageOwner;
	}

	public UserDAO getUserOperation() {
		return userOperation;
	}

	public void setUserOperation(UserDAO userOperation) {
		this.userOperation = userOperation;
	}

	public Set<Activity> getOwnedActivity() {
		return ownedActivity;
	}

	public void setOwnedActivity(Set<Activity> ownedActivity) {
		this.ownedActivity = ownedActivity;
	}

	public Set<Activity> getJoinedActivity() {
		return joinedActivity;
	}

	public void setJoinedActivity(Set<Activity> joinedActivity) {
		this.joinedActivity = joinedActivity;
	}

}
