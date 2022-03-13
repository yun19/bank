package Bank;

class Info {
	private String accountNumber;
	private String password;
	private String name;
	private int check;
	
	public Info(String accountNumber, String password, String name, int check) {
		this.accountNumber= accountNumber;
		this.password = password;
		this.name=name;
		this.check=check;
	}
	public String getAccountInfo() {
		return "계좌번호: " + accountNumber +"예금주명: "+ name+"비밀번호: "+ password+"잔고: "+ check ;  
	}
	public String getAccountNumber() {
		return accountNumber;  
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	//비밀번호 
	public String getPassword() {
		return password;  
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//사용자 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//잔고
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	public void deposit(int deposit) {
		if(deposit<=0) {
			System.out.println("다시 입력하세요.");
			return;
		}
		check+=deposit; //입금 후 잔액
	}
	public void withdraw(int withdraw) {
		if(withdraw>check) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		check-=withdraw;
	}
}
