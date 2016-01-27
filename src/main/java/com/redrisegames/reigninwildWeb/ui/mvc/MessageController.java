/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.redrisegames.reigninwildWeb.ui.mvc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.redrisegames.reigninwildWeb.orm.News;
import com.redrisegames.reigninwildWeb.services.IEmailsService;
import com.redrisegames.reigninwildWeb.services.IMediaService;
import com.redrisegames.reigninwildWeb.services.INewsService;
import com.redrisegames.reigninwildWeb.services.IUsersService;
import com.redrisegames.reigninwildWeb.orm.Media;
import com.redrisegames.reigninwildWeb.orm.Users;
import com.redrisegames.reigninwildWeb.orm.Emails;
import com.redrisegames.reigninwildWeb.web.EmailUtility;



/**
 * @author Rob Winch
 */
@Controller
public class MessageController {
    
	/*--------------------------------------------------------------------*/
	// for logging
    private static final Logger LOG = Logger.getLogger(MessageController.class.getName());
    
	@Autowired
    private INewsService newsService;
	
	@Autowired
    private IEmailsService emailsService;
	
	  @Autowired
	    private IUsersService usersService;
	  
	  @Autowired
      private IMediaService mediaService;
	 
	  
	  @ModelAttribute("news")
	    public News createNews() {
	        return new News();
	    }
	  

	  @RequestMapping("/")
	    public String index(RedirectAttributes attributes, Model model) {
	      
	      News news = new News();
	        try {
	            news = newsService.getLast();
	            model.addAttribute("lastNews", news);
	        } catch (IndexOutOfBoundsException e2) {
	            LOG.log(Level.SEVERE, "Exception: ", e2);
	        } catch (HibernateException e) {
	            LOG.log(Level.SEVERE, "Exception: ", e);
	        }
	      
	        return "home";
	    }
	  
    @RequestMapping("/home")
    public String indexhome(RedirectAttributes attributes, Model model) {
        News news = new News();
        try {
            news = newsService.getLast();
            model.addAttribute("lastNews", news);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        return "home";
    }
    
    @RequestMapping("/index")
    public String index2(RedirectAttributes attributes, Model model) {
        News news = new News();
        try {
            news = newsService.getLast();
            model.addAttribute("lastNews", news);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        return "home";
    }
    
    @RequestMapping("/addnews")
    public String news(RedirectAttributes attributes) {
        return "news";
    }
    
    
    @RequestMapping("/about")
    public String about(RedirectAttributes attributes) {
        return "about";
    }

    
    @RequestMapping("/login")
    public String login(RedirectAttributes attributes) {
        return "login";
    }
    
    @RequestMapping("/upload")
    public String picture(RedirectAttributes attributes) {
        return "upload";
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(RedirectAttributes attributes) {
        return "redirect:/";
    }
    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public String signinFailure(RedirectAttributes attributes) {
        return "redirect:/login";
    }
   

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news, BindingResult result,
            RedirectAttributes attributes, HttpServletRequest request, @RequestParam String newsTitle) throws ParseException {
        // ROLE_USER - default group for new users
        
        
        /*
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Use London's time zone to format the date in
        df.setTimeZone(TimeZone.getTimeZone("Etc/GMT+3"));
        String formated = df.format(date);
        Date converteddate = null;
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        converteddate = df2.parse(formated);
        
        */
        
        SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        //Local time zone   
        SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

        //Time in GMT
       Date date = dateFormatLocal.parse( dateFormatGmt.format(new Date()) );
        
        news.setNewsDate(date);
        news.setNewsTitle(newsTitle);

        
        try {
            newsService.saveNews(news);
        //    mailDelivery("test",news.getNewsText());

        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
            return "redirect:/index#register";
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
            return "redirect:/index#register";
        }

        return "redirect:/";
    }
    
	
	
	
    //select last count news
    @RequestMapping(value = "/subscribe", method = RequestMethod.GET)
    public @ResponseBody int subscribe(final HttpServletRequest request,@RequestParam("email") String email) {
    int result=0;
    try {
       Emails emails = new Emails();
       emails = emailsService.getEmail(email);
       if (emails.getEmail() != null) {
           result = 0;
       }else {
           emails = new Emails();
           emails.setEmail(email);
           emailsService.save(emails);
           result = 1;
       }
       
    } catch (IndexOutOfBoundsException e2) {
        LOG.log(Level.SEVERE, "Exception: ", e2);
    } catch (HibernateException e) {
        LOG.log(Level.SEVERE, "Exception: ", e);
    }
    

        return result;
    }
    
	
	
	
	  //select last count news
    @RequestMapping(value = "/getnews", method = RequestMethod.GET)
    public @ResponseBody int getNewsCount(final HttpServletRequest request) {

        List<News> news = new ArrayList<News>();
        try {
            news = newsService.getAllNews();
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }

        return news.size();
    }
    
    
    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public @ResponseBody String generateEmailList() {

     
        try {
            
            List<Emails> emails = new ArrayList<Emails>();
            emails = emailsService.getEmails();
            
               try { 
                  
                 // File file = new File("C:/email_list.txt");
                 FileWriter writer = new FileWriter("email_list.txt",false);
                 BufferedWriter br = new BufferedWriter(writer);
            
           
                for (int i=0;i<emails.size();i++){

                    br.write(emails.get(i).getEmail());
                    br.newLine();
          
                }
                br.close();
                writer.close();
               
               }
               catch(IOException ex){
                    
                   System.out.println(ex.getMessage());
               } 
            
            
            
            
          
        } catch (Exception ex) {
              System.out.println(ex.getMessage());
        }
        return "1";
      
    } 
    
    //select last count news
    @RequestMapping(value = "/uploadpicture", method = RequestMethod.GET)
    public @ResponseBody int addPicture(final HttpServletRequest request,@RequestParam("desc") String description,@RequestParam("url") String url) {
        
        Media media = new Media();
        media.setType("p");
        media.setDescription(description);
        media.setUrl(url);
    
    try {
            mediaService.save(media);
    } catch (IndexOutOfBoundsException e2) {
        LOG.log(Level.SEVERE, "Exception: ", e2);
        return 0;
    } catch (HibernateException e) {
        LOG.log(Level.SEVERE, "Exception: ", e);
        return 0;
    }
    

        return 1;
    }
    
    //select last count news
    @RequestMapping(value = "/uploadvideo", method = RequestMethod.GET)
    public @ResponseBody int addVideo(final HttpServletRequest request,@RequestParam("desc") String description,@RequestParam("url") String url) {
        
        Media media = new Media();
        media.setType("v");
        media.setDescription(description);
        media.setUrl(url);
    
    try {
            mediaService.save(media);
    } catch (IndexOutOfBoundsException e2) {
        LOG.log(Level.SEVERE, "Exception: ", e2);
        return 0;
    } catch (HibernateException e) {
        LOG.log(Level.SEVERE, "Exception: ", e);
        return 0;
    }
        return 1;
    }
    
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String user;
    @Value("${spring.mail.password}")
    private String pass;
    
    //send email
    @RequestMapping(value = "/sendemail", method = RequestMethod.GET)
    public @ResponseBody String sendEmail(final HttpServletRequest request,@RequestParam("subject") String subject,@RequestParam("content") String content) {
        String result = "0";
        try {
        
            EmailUtility.sendEmail(host, port, user, pass, "reigninwild@gmail.com", subject,
                    content);
            result="1";
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception: ", ex);
            result="0";
        }
      
        return result;
    }
    

}
