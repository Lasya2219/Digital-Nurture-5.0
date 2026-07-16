package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    public static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START");
        LOGGER.debug("Authentication Header: "+authHeader);
        Map<String, String> map = new HashMap<>();

        String user = getUser(authHeader);
        String token = generateJWT(user);
        map.put(user, token);
        LOGGER.debug(user);
        LOGGER.info("END");

        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("GetUser Started");
        String encodedCredentials = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        String user = credentials.substring(0, credentials.indexOf(":"));
        LOGGER.debug(user);
        LOGGER.info("GetUser Ended");
        return user;
    }

    private String generateJWT(String user) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Time of issue of JWT Token
        builder.setIssuedAt(new Date());

        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();

        return token;

    }
}
