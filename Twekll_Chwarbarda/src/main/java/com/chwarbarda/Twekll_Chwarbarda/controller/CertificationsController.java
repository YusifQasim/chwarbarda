package com.chwarbarda.Twekll_Chwarbarda.controller;

import com.chwarbarda.Twekll_Chwarbarda.Repo.CertificationsRepository;
import com.chwarbarda.Twekll_Chwarbarda.models.Certifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CertificationsController {
    private final CertificationsRepository certificationsRepository;

    @Autowired
    public CertificationsController(CertificationsRepository certificationsRepository) {
        this.certificationsRepository = certificationsRepository;
    }

    @PostMapping("/addCertifications")
    public Certifications createCertifications(@RequestBody Certifications certifications) {
        return certificationsRepository.save(certifications);
    }

    @GetMapping("/certifications")
    public String getAllCertifications(Model model) {
        List<Certifications> certifications = certificationsRepository.findAll();
        model.addAttribute("certifications", certifications);
        return "certifications";
    }
}
