/**
 * 
 */
package com.lehecai.core.warning;


/**
 * @author Sunshow
 *
 */
public interface IWarningTool {

	public void sendSMS(WarningType warningType, String message);
	public void sendSMS(WarningType warningType, String message, String contact);
	public void sendSMS(String message, String contact);
	
	public void sendMail(WarningType warningType, String message);
	public void sendMail(WarningType warningType, String message, String contact);
	public void sendMail(String subject, String message, String contact);
}
