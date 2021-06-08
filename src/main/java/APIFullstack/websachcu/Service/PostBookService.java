package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Request.PostBookRequest;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.PostedBookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.PostBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class PostBookService {
    @Autowired
    PostBookRepository postBookRepository;
    @Autowired
    BookRepository bookRepository;
    @Transactional
    public String runPostBookService(PostBookRequest postBookRequest,Integer userid){
//Check data
    if (postBookRequest.getTitle().isEmpty()
        || postBookRequest.getAuthor().isEmpty()
        || postBookRequest.getCategoryId()==null
            ||userid ==null
    ){
        return "bookPage";
    }
    // Lưu sách
    BookEntity bookEntity =new BookEntity();
    bookEntity.setTitle(postBookRequest.getTitle().trim());
    bookEntity.setAuthor(postBookRequest.getAuthor().trim());
    bookEntity.setCategoryId(postBookRequest.getCategoryId());
    bookEntity.setDescription(postBookRequest.getDescription().trim());
    bookEntity.setPicture(postBookRequest.getPicture().trim());
    bookEntity.setPublishYear(postBookRequest.getPublishYear().trim());
    bookEntity.setPrice(postBookRequest.getPrice());
//    bookEntity.setContact(userphone);
    bookEntity = bookRepository.save(bookEntity);
    String returnString = "redirect:/detailPage?id=" + bookEntity.getId();
    // Save PostedBook Table
    PostedBookEntity postedBookEntity =new PostedBookEntity();
    postedBookEntity.setBookId(bookEntity.getId());
    postedBookEntity.setUserId(userid);
    postedBookEntity.setPostedTime(new Date(System.currentTimeMillis()));
    postedBookEntity =postBookRepository.save(postedBookEntity);

    return returnString;
    }

}
