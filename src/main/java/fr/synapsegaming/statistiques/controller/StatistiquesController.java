package fr.synapsegaming.statistiques.controller;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.ui.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller("StatistiquesController")
@SessionAttributes(value = { "resources", "userResources" })
@RequestMapping("/stats")
public class StatistiquesController extends AbstractController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    StatistiquesService statistiquesService;

    /**
     * The default constructor to initialize the page
     *
     * @return modelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        page = new ModelAndView();
        page.setViewName("Statistique");
        page.addObject("resources", resourceService.listMainMenu());
        page.addObject("classes", statistiquesService.listFiveClassesMostPlayed());
        page.addObject("races", statistiquesService.listFiveRacesMostPlayed());
        page.addObject("specializations", statistiquesService.listFiveSpecializationsMostPlayed());
        page.addObject("noavatar", statistiquesService.listUserWithoutAvatar());
        if (user != null)
            page.addObject("userResources", resourceService.listUserResources(user.getGroup().getId()));
        return page;
    }

}