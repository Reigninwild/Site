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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.redrisegames.reigninwildWeb.services.INewsService;
import com.redrisegames.reigninwildWeb.services.IUsersService;
import com.redrisegames.reigninwildWeb.orm.Users;
import com.redrisegames.reigninwildWeb.orm.Emails;



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
	  
	  @ModelAttribute("news")
	    public News createNews() {
	        return new News();
	    }
	  
	  @ModelAttribute("allnews")
      public List<News> allNews() {
	      List<News> news = new ArrayList<News>();
	        try {
	            news = newsService.getAllNews();
	        } catch (IndexOutOfBoundsException e2) {
	            LOG.log(Level.SEVERE, "Exception: ", e2);
	        } catch (HibernateException e) {
	            LOG.log(Level.SEVERE, "Exception: ", e);
	        }
            return news;
      }
	
	  @RequestMapping("/")
	    public String index(RedirectAttributes attributes) {
	        return "home";
	    }
	  
    @RequestMapping("/home")
    public String indexhome(RedirectAttributes attributes) {
        return "home";
    }
    
    @RequestMapping("/addnews")
    public String news(RedirectAttributes attributes) {
        return "news";
    }
    

    
    @RequestMapping("/contacts")
    public String contacts(RedirectAttributes attributes) {
        return "contacts";
    }
    
    @RequestMapping("/about")
    public String about(RedirectAttributes attributes) {
        return "about";
    }
    
    @RequestMapping("/news")
    public String allnews(RedirectAttributes attributes) {
        return "allnews";
    }
    
    @RequestMapping("/gallary")
    public String gallary(RedirectAttributes attributes) {
        return "gallary";
    }
    
    @RequestMapping("/videos")
    public String videos(RedirectAttributes attributes) {
        return "videos";
    }

    @RequestMapping(value="/errors/404.html")
    public String handle404() {
        return "home";
    }
    
    @RequestMapping("/login")
    public String login(RedirectAttributes attributes) {
        return "login";
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(RedirectAttributes attributes) {
        return "redirect:/";
    }
    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public String signinFailure(RedirectAttributes attributes) {
        return "redirect:/login";
    }
	
	
    //select last 3 news
    @ModelAttribute("lastNews")
    public News loadLast(final HttpServletRequest request) {

        News news = new News();
        try {
            news = newsService.getLast();
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }

        return news;
    }
   

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news, BindingResult result,
            RedirectAttributes attributes, HttpServletRequest request, @RequestParam String newsTitle) {
        // ROLE_USER - default group for new users
        
        
        news.setNewsDate(new Date());
        news.setNewsTitle(newsTitle);
        Users user = new Users();
        try{
            user = usersService.getUserbyName(request.getUserPrincipal().getName());  
        } catch(Exception e){
            
        }
         
        news.setUuser(user);
        
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

}
