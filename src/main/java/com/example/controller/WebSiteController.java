package com.example.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/web")
public class WebSiteController {

    @GetMapping(value = "/one")
    public ResponseEntity<?> getSiteOne() {
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>("How are you?", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/two")
    public ResponseEntity<?> getSiteTwo() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/tree")
    public ResponseEntity<?> getSiteTree() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/four")
    public ResponseEntity<?> getSiteFour() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/five")
    public ResponseEntity<?> getSiteFive() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/six")
    public ResponseEntity<?> getSiteSix() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/seven")
    public ResponseEntity<?> getSiteSeven() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/eight")
    public ResponseEntity<?> getSiteEight() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/nine")
    public ResponseEntity<?> getSiteNine() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/ten")
    public ResponseEntity<?> getSiteTen() {
        HttpHeaders responseHeaders = new HttpHeaders();

        return new ResponseEntity<>("Hello", responseHeaders, HttpStatus.OK);
    }

}
