package com.reigninwild.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reigninwild.orm.News;
import com.reigninwild.orm.Users;
import com.reigninwild.services.INewsService;
import com.reigninwild.services.IUsersService;

@Controller
public class MainController {
    
    @Autowired
    private IUsersService usersService;
    
    @Autowired
    private INewsService newsService;
    
    // for logging
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());
    
    @RequestMapping("/")
    public String home(RedirectAttributes attributes) {
        return "index";
    }
    
    @RequestMapping("/index")
    public String index(RedirectAttributes attributes) {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(RedirectAttributes attributes) {
        return "login";
    }
    
    @RequestMapping("/addnews")
    public String news(RedirectAttributes attributes) {
        return "news";
    }


    
    @ModelAttribute("news")
    public News createNews() {
        return new News();
    }
    
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(RedirectAttributes attributes) {
        return "redirect:/";
    }

    /**
     * if sing in failed
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/signin-failure", method = RequestMethod.GET)
    public String signinFailure(RedirectAttributes attributes) {
        return "redirect:/login";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news, BindingResult result,
            RedirectAttributes attributes, HttpServletRequest request) {
        // ROLE_USER - default group for new users
        
        news.setNewsDate(new Date());
        
        Users user = new Users();
        user = usersService.getUserbyName(request.getUserPrincipal().getName());   
        news.setUuser(user);
        
        try {
            newsService.saveNews(news);

        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
            return "redirect:/index#register";
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
            return "redirect:/index#register";
        }

        return "redirect:/index";
    }
    
    
    
    
    //select last 3 news
    @ModelAttribute("allNews")
    public List<News> loadAllNews(final HttpServletRequest request) {

        List<News> news = new ArrayList<News>();
        try {
            news = newsService.getNewsCount(0);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }

        return news;
    }
    
   
    
    //select last count news
    @RequestMapping(value = "/getnews", method = RequestMethod.GET)
    public @ResponseBody List<News> getNewsCount(final HttpServletRequest request,@RequestParam("count") int count) {

        List<News> news = new ArrayList<News>();
        try {
            news = newsService.getNewsCount(count);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }

        return news;
    }
    
    
    
    @RequestMapping(value = "news{id}", method = RequestMethod.GET)
    public String showFullNews(@PathVariable("id") int id, Model model) {
        
        News news = new News();
        news = newsService.getTarget(id);
        model.addAttribute("news",news);
        
        return "targetnews";
    }
    
    
}
