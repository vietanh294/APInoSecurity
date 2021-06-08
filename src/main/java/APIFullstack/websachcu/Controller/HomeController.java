package APIFullstack.websachcu.Controller;
import APIFullstack.websachcu.Controller.Request.HomeRequest;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CategoryEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;

import APIFullstack.websachcu.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/homePage")
public class HomeController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    UserFormSignedIn userFormSignedIn;
    @Autowired
    HomeService homeService;

    @GetMapping
    public String homePage(Model modelHomepage){
//        List<BookEntity>  homeBookForms = bookRepository.findAll();
        List<CategoryEntity> cateItems = categoryRepository.findAll();
        HomeRequest homeRequest = new HomeRequest();
        List<BookEntity>  homeBookForms = homeService.runHomeService(homeRequest);
        homeRequest =homeService.countTotalPages(homeRequest);
        List<Integer> pageNums = homeService.getPageNums(homeRequest.getPageNumber(),homeRequest.getTotalPages());
        modelHomepage.addAttribute("homeRequest",homeRequest);
        modelHomepage.addAttribute("homeBookForms", homeBookForms);
        modelHomepage.addAttribute("categoyItems",cateItems);
        modelHomepage.addAttribute("userFormSignedIn1",userFormSignedIn);
        modelHomepage.addAttribute("pageNums",pageNums);

        return "homePage";
    }

    @PostMapping
    public String homePage(Model modelHomepage,
                           @ModelAttribute("homeRequest") HomeRequest homeRequest2){
        List<CategoryEntity> cateItems = categoryRepository.findAll();
        List<BookEntity> homeBookForms = homeService.runHomeService(homeRequest2);
        homeRequest2 =homeService.countTotalPages(homeRequest2);
        if (homeRequest2.getPageNumber()>homeRequest2.getTotalPages()){
            homeRequest2.setPageNumber(1);
        }
        modelHomepage.addAttribute("homeRequest",homeRequest2);
        modelHomepage.addAttribute("homeBookForms", homeBookForms);
        modelHomepage.addAttribute("categoyItems",cateItems);
        modelHomepage.addAttribute("userFormSignedIn1",userFormSignedIn);
        List<Integer> pageNums = homeService.getPageNums(homeRequest2.getPageNumber(),homeRequest2.getTotalPages());
        modelHomepage.addAttribute("pageNums",pageNums);
        return "homePage";
    }
}

