/*
 * Copyright (c) Smals
 */
package be.bbk.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

/**
 * @author kc
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HeadlineControllerTest {

    @LocalServerPort
    private int port;

    @Test(expected = HttpClientErrorException.class)
    public void pageNotFound() {
        try {
            RestTemplate rest = new RestTemplate();
            rest.getForObject("http://localhost:" + port + "/pdpPutesByNight", String.class);
            fail("Should result in HTTP 404");
        } catch (HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
            throw e;
        }
    }

    // TODO fix Test returns a http 500 
    @Ignore
    @Test()
    public void pageFound() {
        RestTemplate rest = new RestTemplate();        
         Assert.assertNotNull(rest.getForObject("http://localhost:" + port + "/headlines", Object[].class));
    }
}