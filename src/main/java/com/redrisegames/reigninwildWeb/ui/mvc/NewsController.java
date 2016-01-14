package com.redrisegames.reigninwildWeb.ui.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.redrisegames.reigninwildWeb.orm.Emails;
import com.redrisegames.reigninwildWeb.orm.News;
import com.redrisegames.reigninwildWeb.services.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

 // for logging
    private static final Logger LOG = Logger.getLogger(NewsController.class.getName());
    
    public String timezone;
    
    @Autowired
    private INewsService newsService;
   
    @RequestMapping("")
    public String allnews(RedirectAttributes attributes,Model model) {
       List<News> allNews = new ArrayList<News>();
       int count=0;
        try {
           // System.err.println(timezone);
            allNews = newsService.getNewsCount(1, 3);
            Collections.reverse(allNews);
            model.addAttribute("allnews", allNews);
            
            count=newsService.getCount();
            model.addAttribute("newsCount", count);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        return "allnews";
    }
    /*
    @ModelAttribute("allnews")
    public List<News> allNews() {
        List<News> news = new ArrayList<News>();
          try {
              System.err.println(timezone);
              news = newsService.getAllNews();
              Collections.reverse(news);
          } catch (IndexOutOfBoundsException e2) {
              LOG.log(Level.SEVERE, "Exception: ", e2);
          } catch (HibernateException e) {
              LOG.log(Level.SEVERE, "Exception: ", e);
          }
          return news;
    }
    */
    
    @RequestMapping(value = "/getnewscount", method = RequestMethod.GET)
    public @ResponseBody List<News> getNewsCount(final HttpServletRequest request,@RequestParam("page") int page) {
       
        List<News> allNews = new ArrayList<News>();
        try {
            allNews = newsService.getNewsCount(page, 3);
 
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        
        return allNews;
    }


    @RequestMapping(value = "/settimezone", method = RequestMethod.GET)
    public @ResponseBody int subscribe(final HttpServletRequest request,@RequestParam("timezone") String timezone_value) {
        timezone = timezone_value;
        return 1;
    }
    
    
}