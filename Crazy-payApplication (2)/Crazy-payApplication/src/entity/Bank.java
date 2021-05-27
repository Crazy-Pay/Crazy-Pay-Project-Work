package entity;
public class Bank {
	
	private int BankId;
	
	private String BankName;

	public int getBankId() {
		return BankId;
	}

	public void setBankId(int bankId) {
		BankId = bankId;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public Bank(int bankId, String bankName) {
		super();
		BankId = bankId;
		BankName = bankName;
	}
	
	
	

}
