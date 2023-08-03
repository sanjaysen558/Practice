package email;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class GmailSender {

    public boolean sendEmail(String to,String from,String subject,String txt){
        boolean flag = false;
        Properties properties = new Properties();

        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        String user = "sanjay.sen@acuteinformatics.in";
        String password = "rhxisspgxzvsvvmz";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        try{
            File file = new File("C:\\Users\\Dell\\Downloads\\RE-OPEN LEAD-TRANCH.SQL");
            File file1 = new File("C:\\Users\\Dell\\Downloads\\Rishabh Shrirame.pdf");

            MimeMultipart mimeMultipart = new MimeMultipart();

            //file attachment
            //1
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(file);
            mimeMultipart.addBodyPart(attachmentPart);
            //2
            attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(file1);
            mimeMultipart.addBodyPart(attachmentPart);

            //2
//            attachmentPart = new MimeBodyPart();
//            attachmentPart.attachFile(file1);
//            mimeMultipart.addBodyPart(attachmentPart);

            //set html
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(txt,"text/html");
            mimeMultipart.addBodyPart(htmlPart);


            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setContent(txt,"text/html");
            message.setContent(mimeMultipart);
            message.setSubject(subject);
            System.out.println(message.getSentDate());

            Transport.send(message);
            System.out.println(message.getSentDate());

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
