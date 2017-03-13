package uia.syslog.we;

import java.util.Locale;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class WindowsEvent4672Test extends WindowsEventTest {
	
	@Test
	public void testUS() throws Exception{
		String content = "Subject: " +
				"Security ID:  ACME\\Administrator " +
				"Account Name:  Administrator " +
				"Account Domain:  ACME " +
				"Logon ID:  0x1f41e " +
				"Privileges: " +
				"SeSecurityPrivilege " + 
				"SeTakeOwnershipPrivilege ";
		
		test("4672", content, Locale.US);
	}

	@Test
	public void testTW() throws Exception{
		String content = "主旨: " + 
				"安全性識別碼:  ACME\\Administrator " +
				"帳戶名稱:  Administrator " +
				"帳戶網域:  ACME " +
				"登入識別碼:  0x1f41e " +
				"特殊權限: " +
				"SeSecurityPrivilege " + 
				"SeTakeOwnershipPrivilege ";
		
		test("4672", content, Locale.TAIWAN);
	}
	
	@Override
	protected void validate(Map<String, Object> result) {
		Assert.assertEquals(result.get("securityId"), "ACME\\Administrator");
		Assert.assertEquals(result.get("accountName"), "Administrator");
		Assert.assertEquals(result.get("accountDomain"), "ACME");
		Assert.assertEquals(result.get("logonId"), "0x1f41e");
		Assert.assertEquals(result.get("privileges"), "SeSecurityPrivilege SeTakeOwnershipPrivilege");
	}
}