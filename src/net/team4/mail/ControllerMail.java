package net.team4.mail;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import net.team4.codes.CreateFile;

public class ControllerMail {
    
    private static ControllerMail instance;
    
    public static ControllerMail getInstance(){
        if(instance==null){
            instance=new ControllerMail();
        }
        return instance;
    }
    
    public boolean sendMail(Mail mail){
        boolean status=false;
        try {
            Properties p=new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", mail.getUserMail());
            p.setProperty("mail.smtp.auth", "true");

            Session s=Session.getDefaultInstance(p,null); 
            BodyPart texto=new MimeBodyPart();
            texto.setText(mail.getMessage());


            MimeMultipart m=new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje=new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(mail.getUserMail()));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getDestiny()));
            mensaje.setSubject(mail.getAffair());
            mensaje.setText(mail.getMessage(),"ISO-8859-1","html");
            mensaje.setContent(m);
            Transport t=s.getTransport("smtp");
            t.connect(mail.getUserMail(), mail.getPasswordMail());
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            status=true;
        } catch (Exception e) {
            CreateFile.getInstance().writeFileLogs(null, e);
        }
        return status;
    }
}
