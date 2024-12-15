package com.konsilix.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

import static com.konsilix.app.Utils.getMyHostname;

@Slf4j // this gives access to a logger called "log"
@Controller
public class MyController {

    @Autowired
    private SpringResourceTemplateResolver templateResolver;

    @GetMapping("/")
    public String index(Model model) {
        // ... in a method where you can access the templateResolver ...
        String prefix = templateResolver.getPrefix();
        String suffix = templateResolver.getSuffix();
        log.info("Thymeleaf template prefix: {} ", prefix);
        log.info("Thymeleaf template suffix: {} ", suffix);

        model.addAttribute("hostname", getMyHostname());
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "index.html"; // This will return src/main/resources/templates/index.html
    }
}
