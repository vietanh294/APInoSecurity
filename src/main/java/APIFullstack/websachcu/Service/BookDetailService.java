//package APIFullstack.websachcu.Service;
//
//import APIFullstack.websachcu.Controller.Response.UserFormSignedIn;
//import APIFullstack.websachcu.Entity.BookEntity;
//import APIFullstack.websachcu.Repository.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//
//@Service
//public class BookDetailService {
//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    UserFormSignedIn userFormSignedIn;
//    @Autowired
//    PostBookService postBookService;
//    public String runBookDetailService (Integer bookId){
//        List<BookEntity> bookDetail = bookRepository.findAllById(bookId);
//        return "";
//    }
//
//}