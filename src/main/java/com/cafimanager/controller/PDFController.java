package com.cafimanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafimanager.model.Ville;
import com.cafimanager.service.VilleService;
import com.cafimanager.util.GeneratePdfReport;
import com.cafimanager.util.GeneratePdfTicket;

import lombok.var;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class PDFController {

    @Autowired
    private VilleService villeService;

    @RequestMapping(value = "/admin/pdfreport/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport(@PathVariable("id") String id) {

        var cities = (List<Ville>) villeService.findAll();

        ByteArrayInputStream bis = GeneratePdfTicket.citiesReport(cities,id);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport"+id+".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}