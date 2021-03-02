package ua.avadamedia.dz4.Delegate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.avadamedia.dz4.Model.BrandModel;
import ua.avadamedia.dz4.ModelDAO.IBrandModelDAO;

import java.util.UUID;

@Controller
public class ControllerMVC {

    @Autowired
    public IBrandModelDAO brandModelDAO;

    @RequestMapping(value = "/MVC", method = RequestMethod.GET)
    public String mainMVC_Page(Model model) {
        brandModelDAO.addNewBrand(new BrandModel(UUID.randomUUID(), "Asus", 12));
        brandModelDAO.addNewBrand(new BrandModel(UUID.randomUUID(), "Apple", 30));
        brandModelDAO.addNewBrand(new BrandModel(UUID.randomUUID(), "Lenovo", 15));
        model.addAttribute("val1", brandModelDAO.getAllData());
        return "index";
    }

}
