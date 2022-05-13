package com.ais.hrmis.api;

//import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
//import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 public class ApiApplicationTests {

	@Test
	public void contextLoads() {
//		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//	    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//	    config.setPassword("951ed93c25ea3d86ac08d3842f640083"); // encryptor's private key
//	    config.setAlgorithm("PBEWithMD5AndDES");
//	    config.setKeyObtentionIterations("1000");
//	    config.setPoolSize("1");
//	    config.setProviderName("SunJCE");
//	    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//	    config.setStringOutputType("base64");
//	    encryptor.setConfig(config);
//	    String plainText = "AIS_Web_User";
//	    String encryptedPassword = encryptor.encrypt(plainText);
//	    System.out.println("encryptedPassword : " + encryptedPassword);
	}

}
