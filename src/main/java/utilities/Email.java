//********************
//    Author of Code :- Piyush
//********************




package utilities;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;

public class Email {

	public static String VerifyEmail(String email, String password) {

		String URL = null;
		String user = null;

		try {
			
//			Thread.sleep(30000);
			Properties props = new Properties(); // set email protocol to IMAP
			props.put("mail.store.protocol", "imaps"); // set up the session
			Session session = Session.getInstance(props, null);
			Store store = session.getStore("imaps"); // Connect to your email account
			store.connect("imap.gmail.com", email, password); // Get reference to your INBOX
			Folder folder = store.getFolder("INBOX"); // Open the folder in READ MODE only
			folder.open(Folder.READ_ONLY); // Get all the messages in INBOX into Message array

			SearchTerm searchCondition = new SearchTerm() {
				@Override
				public boolean match(Message message) {
					try {
						if (message.getSubject().contains("JIRA")) {
							return true;
						}
					} catch (MessagingException ex) {
						ex.printStackTrace();
					}
					return false;
				}
			};

			Message[] foundMessages = folder.search(searchCondition);

			for (int i = 0; i < foundMessages.length; i++) {
				Message message = foundMessages[i];
				String content = message.getContent().toString();
				String data = null;
				String[] arr1 = content.split("username=");
				String[] arr2 = arr1[1].split("\"");
				data = arr2[0];
				URL = "https://sandbox.xpand-it.com/secure/ResetPassword!default.jspa?os_username="
						+ data.replace("amp;", "");
				user = data.split("&")[0]; 
			}

		} catch (MessagingException ME) {
			ME.printStackTrace();

		} catch (Exception E) {
			E.printStackTrace();
		}

		LoadProperties.config.setProperty("user", user);
		System.out.println("URL= " + URL);
		System.out.println("User= " + user);
		return URL;

	}

}
