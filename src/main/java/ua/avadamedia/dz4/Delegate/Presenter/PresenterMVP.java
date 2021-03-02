package ua.avadamedia.dz4.Delegate.Presenter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PresenterMVP {

    @RequestMapping(value = "/MVP", method = RequestMethod.GET)
    public String mainMVP_Page() {
        return "jsp/java_servlet_page";
    }

}
