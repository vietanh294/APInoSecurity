//package APIFullstack.websachcu.Service;
//
//import APIFullstack.websachcu.Controller.Request.AddBookRequest;
//import APIFullstack.websachcu.Controller.Request.UpdateBookRequest;
//import APIFullstack.websachcu.Controller.Response.BookListResponse;
//import APIFullstack.websachcu.Entity.BookEntity;
//import APIFullstack.websachcu.Entity.CategoryEntity;
//import APIFullstack.websachcu.Repository.BookRepository;
//import APIFullstack.websachcu.Repository.CategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.transaction.Transactional;
//import java.security.PublicKey;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BookServiceSample {
//
//    @Autowired
//    BookRepository bookRepository;
//    @Autowired
//    CategoryRepository categoryRepository;
//
//    public BookListResponse getBookByCategoryId(Integer cateId, String order, String orderby,Integer pageNum){
//
////        Sort sort = Sort.by(Sort.Direction.ASC,orderby);
////        if (order.equals("DESC")){
////            sort = Sort.by(Sort.Direction.DESC,orderby);
////        }
////        PageRequest pageRequest =PageRequest.of(1,2,sort);
//
//        BookListResponse response = new BookListResponse();
//        List<BookEntity> data = bookRepository.findAllByCategoryId(cateId, pageRequest);
//        List<CategoryEntity> categoryData = categoryRepository.findAllByCateId(cateId);
////        Select *
////        List<BookEntity> data = bookRepository.findAll();
//
//        response.setCode(200);
//        response.setData(data);
//
//        response.setCategoryData(categoryData);
//        response.setMessage("Success");
//        return response;
//    }
////    public BookEntity addNewBook(BookEntity bookEntity){
////        return bookRepository.save(bookEntity);
////    }
////    public List<BookEntity> addListBook(List<AddBookRequest> requests){
////        List<BookEntity> bookEntities =new ArrayList<>();
////        for(AddBookRequest e : requests){
////            BookEntity item =new BookEntity();
////            item.setTitle(e.getTitle());
////            item.setAuthor(e.getAuthor());
////            item.setCategoryId(e.getCategoryId());
////            bookEntities.add(item);
////        }
////        bookEntities = bookRepository.saveAll(bookEntities);
////        return bookEntities;
////    }
////
////    public BookEntity updateBook(UpdateBookRequest request){
////        BookEntity entity = bookRepository.findById(request.getId()).orElse(null);
////        if (entity ==null){
////            System.out.println("Not exist ID: " + request.getId());
////            return null;
////        }
////        entity.setTitle(request.getTitle());
////        entity.setAuthor(request.getAuthor());
////        entity =bookRepository.save(entity);
////        return entity;
////    }
////    public BookEntity findOneById(Integer idbook){
////        return bookRepository.findById(idbook).orElse(null);
////    }
////
////    public String deleteBook(Integer id){
////        BookEntity entity = bookRepository.findById(id).orElse(null);
////        if (entity ==null){
////            System.out.println("Not exist ID: " + id);
////            return null;
////        }
////        bookRepository.delete(entity);
////        return "OK";
////    }
////
////    @Transactional
////    public String updateBookNative(String title, Integer id){
////        BookEntity bookEntity =bookRepository.findById(id).orElse(null);
////        if (bookEntity==null){
////            System.out.println("Not exist ID: " + id);
////            return  null;
////        }
////        bookRepository.updateBookByNativeModify(title,id);
////        return "OK";
////    }
//
////    public void getIdAndTitle(){
////        List<Object[]> objects = bookRepository.getTitleAndId();
////        for (Object[] ob :
////                objects) {
////            Integer id = (Integer) ob[0];
////            String title = String.valueOf(ob[1]);
////        }
////    }
//
//}
