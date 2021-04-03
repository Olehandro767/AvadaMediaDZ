package ua.AvadaMedia.admin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.AvadaMedia.admin.Common.ModelInfo;

@Controller
@RequestMapping("/admin/movie")
public class MovieController {

    @GetMapping("/")
    public String index(Model model) {
        new ModelInfo(model).addLinks();
        model.addAttribute("movie_page_link", "/admin/movie/moviePage");
        return "movie/index";
    }

    @RequestMapping(value = "/moviePage", method = RequestMethod.GET)
    public String moviePage(
            @RequestParam(value = "id", required = false) Long id,
            Model model
    ) {
        new ModelInfo(model).addLinks();
//        if (id != null) { }
        return "movie/movie_page";
    }

}