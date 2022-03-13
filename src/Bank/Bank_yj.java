package Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bank_yj {
	private static Info[] infos = new Info[20];
	private static int index =0;

	public static void main(String[] args) throws IOException{
		BufferedReader A = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false;
		do {
			System.out.println("=========은행 계좌 프로그램=========");
			System.out.println("1. 계좌 개설");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 잔액");
			System.out.println("5. 전체 계좌 조회");
			System.out.println("6. 종료");
			System.out.println("메뉴 번호를 입력해주세요");
			
			int menu =Integer.parseInt(A.readLine());
			switch(menu){
				case 1 :
					System.out.println("계좌 개설");
					createAccount();
					break;
				case 2 :
					System.out.println("입금");
					checkIn();
					break;
				case 3 :
					System.out.println("출금");
					checkOut();
					break;
				case 4 :
					System.out.println("잔액");
					check_bank();
					break;
				case 5 :
					System.out.println("전체 계좌 조회");
					checkAccountInfo();
					break;
				case 6 :
					System.out.println("종료");
					exit = true;
					break;
				default :
					System.out.println("잘못 입력하셨습니다.");
				
			}
		}while(!exit);

	}
	public static int checkAccount(String accountNumber) { //계좌 확인
		for(int i=0; i< index; i++) {
			if(infos[i].getAccountNumber().contentEquals(accountNumber)) {
				return i;
			}
		}
		return -1;
	}
	
	public static void createAccount() throws IOException { //계좌 개설
		BufferedReader A = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("계좌번호: ");
		String accountNumber = A.readLine();
		System.out.print("이름: ");
		String name = A.readLine();
		System.out.print("비밀번호: ");
		String password = A.readLine();
		System.out.print("금액: ");
		int check = Integer.parseInt(A.readLine());
		
		infos[index] = new Info(accountNumber, password, name, check);
		index++;
		
		System.out.println("계좌 계설이 완료되었습니다.");
	}
	
	public static void check_bank() throws IOException { //잔액
		BufferedReader A = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("계좌 번호를 입력해주세요");
		String accountNumber = A.readLine();
		int index = checkAccount(accountNumber);
		if(index !=-1) {
			System.out.printf("계좌번호 %d%n", infos[index].getCheck());
		}
		else {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
	}
	
	public static void checkIn()throws IOException { //입금
		BufferedReader A = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("계좌 번호를 입력해주세요");
		String accountNumber = A.readLine();
		System.out.print("입금금액: ");
		int money = Integer.parseInt(A.readLine());
		
		int index = checkAccount(accountNumber);
		if(index !=-1) {
			infos[index].deposit(money);
		}
		else {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
	}
	
	public static void checkOut() throws IOException{ //출금
		BufferedReader A = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("계좌 번호를 입력해주세요");
		String accountNumber = A.readLine();
		System.out.print("비밀번호를 입력해주세요");
		String password = A.readLine(); 
		System.out.print("출금금액: ");
		int money = Integer.parseInt(A.readLine());
		
		int index = checkAccount(accountNumber);
		if(index ==-1) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
		else {
			if(!infos[index].getPassword().equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return;
			}
			infos[index].withdraw(money);
			System.out.printf("%d원이 성공적으로 인출되었습니다.%n", money);
		}
	}
	public static void checkAccountInfo() { //전체 계좌정보 조회
		for(int i=0; i<index; i++) {
			System.out.printf("%s%n", infos[i].getAccountInfo());
		}
	}
}
