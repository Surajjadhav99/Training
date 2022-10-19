package com.advtraining.core.servlets;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/bin/demoservlet")
public class Demo extends HttpServlet {

    final String RES_PATH="https://gorest.co.in/public/v2/users";
    Logger LOG= LoggerFactory.getLogger(Demo.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        LOG.info(">-------->Working Fine<---------<");



    }
}
