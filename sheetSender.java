
public class sheetSender 
{
	public static void main(String[] args) 
	{
		createEmail email = new createEmail();
		connectToScanner scan = new connectToScanner();
		
		email.getInformation();
		scan.beginScan();
		
		email.attachScan(scan.getScan());
		
		email.setSubject();
		email.composeMessage();
		
		email.sendMessage();

	}
}
