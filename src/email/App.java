package email;

public class App {

    public static void main(String[] args) {
        GmailSender gmailSender = new GmailSender();

        String to = "sanjaysen558@gmail.com";
        String from = "sanjay.sen@acuteinformatics.in";
        String subject = "Send From JAVA App";
        String text = "<h1>Hello <b>Sanjay</b>,Never stop learning<h1>";

        if(gmailSender.sendEmail(to,from,subject,text)) {
            System.out.println("email sent");
        }else{
            System.out.println("failed to send email");
        }
    }

}
