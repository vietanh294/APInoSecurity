//package APIFullstack.websachcu.Controller;
//
//import APIFullstack.websachcu.Controller.Request.AddBookRequest;
//import APIFullstack.websachcu.Controller.Request.UpdateBookRequest;
//import APIFullstack.websachcu.Controller.Response.BookListResponse;
//import APIFullstack.websachcu.Entity.BookEntity;
//import APIFullstack.websachcu.Repository.BookRepository;
//import APIFullstack.websachcu.Service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureOrder;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/book")
//public class BookController {
//
//    @Autowired
//    BookService bookService;
//    @Autowired
//    BookRepository bookRepository;
//
//    @GetMapping(value = "/{category_id}")
//    public BookListResponse getBookByCategoryId(@PathVariable(name = "category_id") Integer cateId,
//                                                @RequestParam(name = "order",defaultValue = "ASC") String order,
//                                                @RequestParam(name = "orderBy",defaultValue = "title") String orderBy){
//        return bookService.getBookByCategoryId(cateId,order,orderBy);
//    }
//
//    @PostMapping(value = "/addOne")
//    public BookEntity addOneBook(@RequestBody AddBookRequest addBookRequest){
//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setTitle(addBookRequest.getTitle());
//        bookEntity.setAuthor(addBookRequest.getAuthor());
//        bookEntity.setCategoryId(addBookRequest.getCategoryId());
//        bookEntity= bookService.addNewBook(bookEntity);
//        return bookEntity;
//    }
//
//    @PostMapping(value = "/addList")
//    public List<BookEntity> addListBook(@RequestBody List<AddBookRequest> requests){
//        return bookService.addListBook(requests);
//    }
//
//    @PutMapping(value = "/update")
//    public BookEntity updateBook(@RequestBody UpdateBookRequest request){
//        return bookService.updateBook(request);
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public  String deleteBook(@PathVariable(name = "id") Integer id){
//        return bookService.deleteBook(id);
//    }
//
//    @GetMapping(value = "/native-query/{Id}")
//    public BookEntity getBookByIdNativeParam(@PathVariable(name = "Id") Integer id){
//        BookEntity entity = bookRepository.findByNameParam(id);
//        return entity;
//    }
//    @GetMapping(value = "/native-query2/{Id}")
//    public BookEntity getBookByIdNativeIndex(@PathVariable(name = "Id") Integer id){
//        BookEntity entity = bookRepository.findByNativeQuery(id);
//        return entity;
//    }
//
//    @PutMapping(value = "/update-title/{id}")
//    public  String updateNative(@PathVariable(name = "id") Integer id,
//                                @RequestParam(value = "title") String title){
//        return bookService.updateBookNative(title,id);
//    }
//}
//
