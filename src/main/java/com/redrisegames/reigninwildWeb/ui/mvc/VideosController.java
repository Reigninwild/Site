package com.redrisegames.reigninwildWeb.ui.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.redrisegames.reigninwildWeb.orm.Media;
import com.redrisegames.reigninwildWeb.services.IMediaService;

@Controller
@RequestMapping("/videos")
public class VideosController {

 // for logging
    private static final Logger LOG = Logger.getLogger(VideosController.class.getName());
    
    @Autowired
    private IMediaService mediaService;
   
    @RequestMapping("")
    public String videos(RedirectAttributes attributes, Model model) {
        
        List<Media> media = new ArrayList<Media>();
        try {
            
            media = mediaService.getVideos();
            model.addAttribute("videos", media);
        } catch (IndexOutOfBoundsException e2) {
            LOG.log(Level.SEVERE, "Exception: ", e2);
        } catch (HibernateException e) {
            LOG.log(Level.SEVERE, "Exception: ", e);
        }
        
        return "videos";
    }
    
}
