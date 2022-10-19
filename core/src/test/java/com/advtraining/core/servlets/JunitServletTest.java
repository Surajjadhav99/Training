package com.advtraining.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class JunitServletTest {

    AemContext aemContext=new AemContext();

    JunitServlet  unitTest=new JunitServlet();

    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet() throws IOException {

        aemContext.build().resource("/content/we-retail");
        MockSlingHttpServletRequest request=aemContext.request();
        MockSlingHttpServletResponse response=aemContext.response();

        unitTest.doGet(request,response);

        assertEquals("Response=200",response.getOutputAsString());
    }
}