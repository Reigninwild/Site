package com.redrisegames.reigninwildWeb.ui.mvc;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ServerCustomization extends ServerProperties {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {

      super.customize(container);
      container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
              "/WEB-INF/views/errorpage.jsp"));
      container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
              "/WEB-INF/views/internalerror.jsp"));
      container.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,
              "/WEB-INF/views/internalerror.jsp"));
      container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,
              "/WEB-INF/views/internalerror.jsp"));
      container.addErrorPages(new ErrorPage(HttpStatus.TOO_MANY_REQUESTS,
              "/WEB-INF/views/internalerror.jsp"));
      container.addErrorPages(new ErrorPage("/internalerror"));
    }

  }