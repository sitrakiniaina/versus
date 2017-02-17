package mapping;

/***********************************************************************

 * Module:  Token.java
 * Author:  Jonathan
 * Purpose: Defines the Class Token
 ***********************************************************************/


/** @pdOid 2a055aff-a347-46c7-954e-a27d67998dd5 */
public class Token 
{
	 long idtoken;
	 String code;
	 
	public Token(long idtoken, String code) {
		super();
		this.idtoken = idtoken;
		this.code = code;
	}
	public long getIdtoken() {
		return idtoken;
	}
	public void setIdtoken(long idtoken) {
		this.idtoken = idtoken;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	 
	 
	 
}