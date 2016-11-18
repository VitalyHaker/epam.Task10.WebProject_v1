package by.tc.sshop.bean.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class User {
	private int idUser;
	private String login;
    private String pass;
    private String email;
    private String phone;
    private BigDecimal balance;
    private int coupon;    
    private String fname;
    private String lname;
    private Date birth;
    private int role;
    private int blockSt;
    private int delSt;
      
    public User() {
	}
    
	public User(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	public User(String login, String pass, String email, String phone) {
		this.login = login;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
	}
	
	public User(String login, String pass, String email, String phone, BigDecimal balance, int coupon, String fname,
			String lname, Date birth) {
		super();
		this.login = login;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.coupon = coupon;
		this.fname = fname;
		this.lname = lname;
		this.birth = birth;
	}

	public User(int idUser, String login, String pass, String email, String phone, BigDecimal balance, int coupon,
			String fname, String lname, Date birth, int role, int blockSt, int delSt) {
		this.idUser = idUser;
		this.login = login;
		this.pass = pass;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.coupon = coupon;
		this.fname = fname;
		this.lname = lname;
		this.birth = birth;
		this.role = role;
		this.blockSt = blockSt;
		this.delSt = delSt;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getBlockSt() {
		return blockSt;
	}

	public void setBlockSt(int blockSt) {
		this.blockSt = blockSt;
	}

	public int getDelSt() {
		return delSt;
	}

	public void setDelSt(int delSt) {
		this.delSt = delSt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + blockSt;
		result = prime * result + coupon;
		result = prime * result + delSt;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + idUser;
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + role;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (blockSt != other.blockSt)
			return false;
		if (coupon != other.coupon)
			return false;
		if (delSt != other.delSt)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (idUser != other.idUser)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (role != other.role)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", pass=" + pass + ", email=" + email + ", phone="
				+ phone + ", balance=" + balance + ", coupon=" + coupon + ", fname=" + fname + ", lname=" + lname
				+ ", birth=" + birth + ", role=" + role + ", blockSt=" + blockSt + ", delSt=" + delSt + "]";
	}
 
}
