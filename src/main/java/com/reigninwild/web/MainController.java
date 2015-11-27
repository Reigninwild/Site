package com.reigninwild.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
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

import com.reigninwild.orm.Crafts;
import com.reigninwild.orm.Emails;
import com.reigninwild.orm.Materials;
import com.reigninwild.orm.News;
import com.reigninwild.orm.Users;
import com.reigninwild.services.ICraftsService;
import com.reigninwild.services.IEmailsService;
import com.reigninwild.services.IMaterialsService;
import com.reigninwild.services.INewsService;
import com.reigninwild.services.IUsersService;


@Controller
public class MainController {
    
    @Autowired
    private IUsersService usersService;
    
    @Autowired
    private INewsService newsService;
    
    @Autowired
    private IMaterialsService materialsService;
    
    @Autowired
    private ICraftsService craftsService;
    
    @Autowired
    private IEmailsService emailsService;
    
    @Autowired
    ServletContext context;
    
    // for logging
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());
    
    @RequestMapping("/")
    public String home(RedirectAttributes attributes) {
        return "home";
    }
    
    @RequestMapping("/home")
    public String indexhome(RedirectAttributes attributes) {
        return "home";
    }
    
    @RequestMapping("/index")
    public String index(RedirectAttributes attributes) {
        return "home";
    }
    
    @RequestMapping("/login")
    public String login(RedirectAttributes attributes) {
        return "login";
    }
    
    @RequestMapping("/addnews")
    public String news(RedirectAttributes attributes) {
        return "news";
    }
    
    @RequestMapping("/addmaterial")
    public String addmaterial(RedirectAttributes attributes) {
        return "addmaterial";
    }
    
    @RequestMapping("/addcraft")
    public String addcraft(RedirectAttributes attributes) {
        return "addcraft";
    }
    
    @RequestMapping("/items")
    public String items(RedirectAttributes attributes) {
    	
        return "items";
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

    
    @ModelAttribute("news")
    public News createNews() {
        return new News();
    }
    
    @ModelAttribute("material")
    public Materials createMaterial() {
        return new Materials();
    }
    
    @ModelAttribute("materials")
    public List<Materials> allMaterials() {
        return materialsService.getAllMaterials();
    }
    
    @ModelAttribute("emptyMaterials")
    public List<Materials> allEmptyMaterials() {
        return materialsService.getEmptyMaterials();
    }
    
    @ModelAttribute("craft")
    public Crafts createCraft() {
        return new Crafts();
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
    
    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news, BindingResult result,
            RedirectAttributes attributes, HttpServletRequest request) {
        // ROLE_USER - default group for new users
        
        news.setNewsDate(new Date());
        
        Users user = new Users();
        user = usersService.getUserbyName(request.getUserPrincipal().getName());   
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

        return "redirect:/index";
    }
    
    @RequestMapping(value = "/addmaterial", method = RequestMethod.POST)
    public String addMaterial(@ModelAttribute("material") Materials material, BindingResult result,
            RedirectAttributes attributes, HttpServletRequest request) {
         
        try {
            materialsService.saveMaterial(material);

        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
            return "redirect:/index#register";
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
            return "redirect:/index#register";
        }

        return "addmaterial";
    }
    
    /*
    @RequestMapping(value = "/addcraft", method = RequestMethod.POST)
    public String addcraft(@ModelAttribute("craft") Crafts craft, BindingResult result,
            RedirectAttributes attributes, HttpServletRequest request) {
         
        try {
            craftsService.saveCraft(craft);

        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
            return "redirect:/index#register";
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
            return "redirect:/index#register";
        }

        return "addcraft";
    }
    */
    
    
    
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
    @RequestMapping(value = "/getallnews", method = RequestMethod.GET)
    public @ResponseBody List<News> getAllNews(final HttpServletRequest request) {

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
    
    //select last count news
    @RequestMapping(value = "/getlast", method = RequestMethod.GET)
    public @ResponseBody News getLast(final HttpServletRequest request) {

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
    
    
    //get materials by type
    @RequestMapping(value = "/getmaterialstype", method = RequestMethod.GET)
    public @ResponseBody List<Materials> getMaterialsType(final HttpServletRequest request,@RequestParam("type") String type) {

        List<Materials> materials = new ArrayList<Materials>();
        try {
           materials = materialsService.getMaterialsByType(type);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        return materials;
    }
    
    
    
    //get materials by type
    @RequestMapping(value = "/getmaterialscraft", method = RequestMethod.GET)
    public @ResponseBody List<Crafts> getMaterialsCraft(final HttpServletRequest request,@RequestParam("id") int id) {

        List<Crafts> crafts = new ArrayList<Crafts>();
        try {
            crafts = craftsService.getCraft(id);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        return crafts;
    }
    
    
    @RequestMapping(value = "news{id}", method = RequestMethod.GET)
    public String showFullNews(@PathVariable("id") int id, Model model) {
        
        News news = new News();
        news = newsService.getTarget(id);
        model.addAttribute("news",news);
        
        return "targetnews";
    }
    
    //select last count news
    @RequestMapping(value = "/savecraft", method = RequestMethod.GET)
    public @ResponseBody String saveCraft(final HttpServletRequest request,@RequestParam("craft_id") int craftID,@RequestParam("material_id") int materialID,@RequestParam("count") int count) {

      Crafts craft = new Crafts();
      Materials material = new Materials();
      Materials item = new Materials();
      
      
        try {
            
            item = materialsService.getMaterial(craftID);
            material = materialsService.getMaterial(materialID);

            
            craft.setItem(item);
            craft.setMaterial(material);
            craft.setMaterialCount(count);
            
            craftsService.saveCraft(craft);
            
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }

        return "1";
    }

    //send email
    @RequestMapping(value = "/sendemail", method = RequestMethod.GET)
    public @ResponseBody String sendEmail(final HttpServletRequest request,@RequestParam("subject") String subject,@RequestParam("content") String content) {

        String host = context.getInitParameter("host");
        String  port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        
        String result = "0";
        try {
        
            EmailUtility.sendEmail(host, port, user, pass, "reigninwild@gmail.com", subject,
                    content);
            result="1";
        } catch (Exception ex) {
            result="0";
        }
      
        return result;
    }
    
    
    //send email
  //  @RequestMapping(value = "/sendemail", method = RequestMethod.GET)
    public  String mailDelivery(String subject,String content) {

        String host = context.getInitParameter("host");
        String  port = context.getInitParameter("port");
        String user = context.getInitParameter("user");
        String pass = context.getInitParameter("pass");
        
        String result = "0";
        try {
        	
        	List<Emails> emails = new ArrayList<Emails>();
        	emails = emailsService.getEmails();
        	
        	for (int i=0;i<emails.size();i++){
        		EmailUtility.sendEmail(host, port, user, pass, emails.get(i).getEmail(), "Reign in wild news and updates",
                        content);
        	}
        	
            
            result="1";
        } catch (Exception ex) {
            result="0";
        }
      
        return result;
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
    
    
    
}
