package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.PostedBookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;
import APIFullstack.websachcu.Repository.PostBookRepository;

import APIFullstack.websachcu.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/detailPage")
public class BookDetailControllor {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserFormSignedIn userFormSignedIn;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PostBookRepository postBookRepository;
    @Autowired
    UserRepository userRepository;

////Getmapping co RequestParam
    @GetMapping
    public String detailPage(Model modelDetailPageAndParam,@RequestParam("id") Integer bookId){
        UserFormSignedIn userFormSignedIn3=userFormSignedIn;
        modelDetailPageAndParam.addAttribute("userFormSignedIn2",userFormSignedIn3);
        BookEntity bookDetail =bookRepository.findByNativeQuery(bookId);
        modelDetailPageAndParam.addAttribute("detailBook",bookDetail);
//      Category
        String categoryName = categoryRepository.findCateNameByNameParamCateId(bookDetail.getCategoryId());
        modelDetailPageAndParam.addAttribute("categoryName",categoryName);
//      Posted Contact
                PostedBookEntity userPostedBook = postBookRepository.findAllByBookId(bookId);
        String userPostedPhone ="No Contact!";
        if (userPostedBook != null){
            userPostedPhone = userRepository.findUserPhoneByNativeQuery(userPostedBook.getUserId());
        }
        modelDetailPageAndParam.addAttribute("userPostedPhone",userPostedPhone);
        return "detailPage";
    }



}
