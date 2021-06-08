package APIFullstack.websachcu.Controller;

import APIFullstack.websachcu.Controller.Request.UserPasswordInfoRequest;
import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
import APIFullstack.websachcu.Controller.Response.UserPageCollectionResponse;
import APIFullstack.websachcu.Controller.Response.UserPagePostedResponse;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CollectionEntity;
import APIFullstack.websachcu.Entity.UserEntity;
import APIFullstack.websachcu.Service.UserService;
import APIFullstack.websachcu.Service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userPage")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserFormSignedIn userFormSignedIn;
    @Autowired
    CollectionService collectionService;
//  Tab Thông tin
    @GetMapping(value = "/info")
    public String userPageInfo(Model modelUserPageInfo){
        String userPhone =userFormSignedIn.getUserSignedPhone();
        modelUserPageInfo.addAttribute("userPhone",userPhone);
        String userEmail =userFormSignedIn.getUserSignedEmail();
        UserEntity userEntity =new UserEntity();
        userEntity.setUserPhone(userPhone);
        userEntity.setUserEmail(userEmail);
        modelUserPageInfo.addAttribute("userPageInfoRequest",userEntity);
        modelUserPageInfo.addAttribute("userPasswordInfoRequest", new UserPasswordInfoRequest());
        return "userPageInfo";
    }
    @GetMapping
    public String userPageInfo2(Model modelUserPageInfo2){
        return "redirect:/userPage/info";
    }
//    @PutMapping(value = "/info")
//    public String putUserPageInfoRequest()

    //    Tab SÁCH ĐÃ ĐĂNG
    @GetMapping(value = "/posted")
    public String userPagePosted(Model modelUserPagePosted){
        modelUserPagePosted.addAttribute("userPagePortedRequest",new BookEntity());
        String userPhone =userFormSignedIn.getUserSignedPhone();
        Integer userId =userFormSignedIn.getUserSignedId();
        List<UserPagePostedResponse> userPagePostedResponseList =userService.UserPagePosted(userId);
        modelUserPagePosted.addAttribute("userPagePostedResponseList",userPagePostedResponseList);
        modelUserPagePosted.addAttribute("userPhone",userPhone);
        return "userPagePosted";
    }

//    TAB SÁCH YÊU THÍCH
    @GetMapping(value = "/collection")
    public String userPageCollection(Model modelUserPageCollection){
        Integer userId = userFormSignedIn.getUserSignedId();
        String userPhone =userFormSignedIn.getUserSignedPhone();
        List<UserPageCollectionResponse> userPageCollectionResponseList = userService.getUserPageCollection(userId);
        modelUserPageCollection.addAttribute("userPageCollectionRequest",new CollectionEntity());
        modelUserPageCollection.addAttribute("userPageCollectionResponseList",userPageCollectionResponseList);
        modelUserPageCollection.addAttribute("userPhone",userPhone);
        return "userPageCollection";
    }
    @PutMapping(value = "/collection")
    public String userUnlikeBookCollection(Model modelUserUnlikeBookCollection,
                                           @ModelAttribute("userPageCollectionRequest")CollectionEntity userPageCollectionRequest,
//                                           @ModelAttribute("userPageCollectionResponseList")List<UserPageCollectionResponse> userPageCollectionResponseList,
                                           @ModelAttribute("userPhone")String userPhone){
        Integer userId =userFormSignedIn.getUserSignedId();
        Integer bookId = userPageCollectionRequest.getBookId();
        Integer likeStatus= collectionService.runUnlikeAndLikeStatus(userId,bookId);
        System.out.println(likeStatus);
        modelUserUnlikeBookCollection.addAttribute("userPageCollectionRequest",new CollectionEntity());
//        modelUserUnlikeBookCollection.addAttribute("userPageCollectionResponseList",userPageCollectionResponseList);
        modelUserUnlikeBookCollection.addAttribute("userPhone",userPhone);
        return "userPageCollection";
    }
}
