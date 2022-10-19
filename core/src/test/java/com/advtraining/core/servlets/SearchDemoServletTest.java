package com.advtraining.core.servlets;

import com.advtraining.core.osgiConfig.impl.OSGITestConfigImpl;
import com.advtraining.core.services.SearchDemo;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.servlethelpers.MockSlingHttpServletRequest;
import org.apache.sling.servlethelpers.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class})
class SearchDemoServletTest {


    AemContext aemContext=new AemContext();
    SearchDemoServlet unitTest=new SearchDemoServlet();

    @OSGiService
    SearchDemo searchDemo;

    @BeforeEach
    void setUp() {


    }

    @Test
    void doPost() throws IOException, ServletException {
        MockSlingHttpServletRequest request=aemContext.request();
        MockSlingHttpServletResponse response=aemContext.response();

        //unitTest.doPost(request,response);
    }
}