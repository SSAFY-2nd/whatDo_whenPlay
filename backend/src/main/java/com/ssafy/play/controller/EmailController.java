//<<<<<<< HEAD
////package com.ssafy.play.controller;
////
////import java.util.Random;
////
////import javax.mail.MessagingException;
////import javax.mail.internet.InternetAddress;
////import javax.mail.internet.MimeMessage;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.mail.javamail.JavaMailSender;
////import org.springframework.mail.javamail.MimeMessageHelper;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RequestParam;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.ssafy.play.model.User;
////import com.ssafy.play.service.UserService;
////import io.swagger.annotations.ApiOperation;
////
////@CrossOrigin(origins = { "*" })
////@RestController
////@RequestMapping("/email")
////public class EmailController {
////
////	@Autowired
////	private JavaMailSender mailSender;
////	
////	@Autowired
////	private UserService UserService;
////	
////	@ApiOperation(value = "비밀번호 이메일로 찾기", response = String.class)
////	@GetMapping
////	public ResponseEntity<String> sendEmailAction (@RequestParam String email) throws Exception {
////        User User = UserService.findUserByEmail(email);
////        String USERNAME = User.getname();
////        String EMAIL = email;
////        StringBuffer sb = new StringBuffer();
////        Random rn = new Random();
////        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
////        for( int i = 0 ; i < 9 ; i++ ){
////            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
////        }
////        String PASSWORD = sb.toString();
////             
////        try {
////            MimeMessage msg = mailSender.createMimeMessage();
////            MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
////            messageHelper.setSubject(USERNAME+"님 비밀번호 찾기 메일입니다.");
////            messageHelper.setText("임시 비밀번호는 "+PASSWORD+" 입니다.");
////            messageHelper.setFrom("ru940203@naver.com");
////   
////            User.setPassword(PASSWORD);
////            UserService.updatePassword(User);
////            messageHelper.setTo(EMAIL);
////            
////            msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(EMAIL));
////            mailSender.send(msg);
////            
////        }catch(MessagingException e) {
////            System.out.println("MessagingException");
////            e.printStackTrace();
////            return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
////        }
////        return new ResponseEntity<String>("success", HttpStatus.OK); 
////    }
////
////}
//=======
//package com.ssafy.play.controller;
//
//import java.util.Random;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ssafy.play.model.User;
//import com.ssafy.play.service.UserService;
//import io.swagger.annotations.ApiOperation;
//
//@CrossOrigin(origins = { "*" })
//@RestController
//@RequestMapping("/email")
//public class EmailController {
//
//	@Autowired
//	private JavaMailSender mailSender;
//	
//	@Autowired
//	private UserService UserService;
//	
//	@ApiOperation(value = "비밀번호 이메일로 찾기", response = String.class)
//	@GetMapping
//	public ResponseEntity<String> sendEmailAction (@RequestParam String email) throws Exception {
//        User User = UserService.findUserByEmail(email);
//        String USERNAME = User.getName();
//        String EMAIL = email;
//        StringBuffer sb = new StringBuffer();
//        Random rn = new Random();
//        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
//        for( int i = 0 ; i < 9 ; i++ ){
//            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
//        }
//        String PASSWORD = sb.toString();
//             
//        try {
//            MimeMessage msg = mailSender.createMimeMessage();
//            MimeMessageHelper messageHelper = new MimeMessageHelper(msg, true, "UTF-8");
//            messageHelper.setSubject(USERNAME+"님 비밀번호 찾기 메일입니다.");
//            messageHelper.setText("임시 비밀번호는 "+PASSWORD+" 입니다.");
//            messageHelper.setFrom("ru940203@naver.com");
//   
//            User.setPassword(PASSWORD);
//            UserService.updatePassword(User);
//            messageHelper.setTo(EMAIL);
//            
//            msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(EMAIL));
//            mailSender.send(msg);
//            
//        }catch(MessagingException e) {
//            System.out.println("MessagingException");
//            e.printStackTrace();
//            return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<String>("success", HttpStatus.OK); 
//    }
//
//}
//>>>>>>> d1f3e4d48d9d0339e510527b05ede311278e5287
