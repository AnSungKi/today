package egovframework.sayit.duplex;

/**
 * 양방향 암호 클래스
 * 
 * @author 임희재
 * @since 2018.03.23
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   
 * </pre>
 * key 값 : 16자리 
 */

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Duplex {

	/* AES 128 bit 암호화 */
	public static String encrypt(String message,String key) throws Exception{
	    if(message == null){
	        return null;
	    }else{
	    	SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
	    	Cipher cipher = Cipher.getInstance("AES");
	    	try{
	    		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	    		
	    	}catch (Exception e){
	    		System.out.println(e);
	    	}
	    	byte[] encrypted = cipher.doFinal(message.getBytes());
	    	return byteArrayToHex(encrypted);
	    }
	}

	private static String byteArrayToHex(byte[] encrypted) {
	    if(encrypted == null || encrypted.length ==0){
	        return null;
	    }
	    StringBuffer sb = new StringBuffer(encrypted.length * 2);
	    String hexNumber;

	    for(int x=0; x<encrypted.length; x++){
	        hexNumber = "0" + Integer.toHexString(0xff & encrypted[x]);
	        sb.append(hexNumber.substring(hexNumber.length() - 2));

	    }

	    return sb.toString();

	}


	/* AES 128 bit 복호화 */
	public static String decrypt(String encrypted,String key) throws Exception{
     
		if(encrypted == null){
	        return null;
	    }else{
	        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
	        byte[] original = cipher.doFinal(hexToByteArray(encrypted));
	        String originalStr = new String(original);
	        return originalStr;
	    }
	}
  
	private static byte[] hexToByteArray(String hex) {
	     
	    if(hex == null || hex.length() == 0){
	        return null;
	    }
	    //16진수 문자열을 byte로 변환
	    byte[] byteArray = new byte[hex.length() /2 ];
	     
	    for(int i=0; i<byteArray.length; i++){
	        byteArray[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2*i+2), 16);
	    }
	    return byteArray;
	}
 


	
}
