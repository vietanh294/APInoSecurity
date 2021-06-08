package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Response.UserPageCollectionResponse;
import APIFullstack.websachcu.Controller.Response.UserPagePostedResponse;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Entity.CollectionEntity;
import APIFullstack.websachcu.Entity.PostedBookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CollectionRepository;

import APIFullstack.websachcu.Repository.PostBookRepository;
import APIFullstack.websachcu.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CollectionRepository collectionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostBookRepository postBookRepository;
    public List<UserPageCollectionResponse> getUserPageCollection(Integer userId){
        //Tim collection co userId va likestatus =1
//        List<BookEntity> bookList =new ArrayList<>();
        List<CollectionEntity> collectionList = collectionRepository.findAllByUserIdAndLikeStatus(userId,1);
        List<UserPageCollectionResponse> userPageCollectionResponseList =new ArrayList<>();
        for (CollectionEntity collectionItem :
                collectionList) {
            BookEntity bookItem = bookRepository.findAllById(collectionItem.getBookId());
            UserPageCollectionResponse userPageCollectionResponseItem = new UserPageCollectionResponse();
            userPageCollectionResponseItem.setBookTitle(bookItem.getTitle());
            userPageCollectionResponseItem.setPublishYear(bookItem.getPublishYear());
            userPageCollectionResponseItem.setBookPrice(bookItem.getPrice());
            userPageCollectionResponseItem.setBookId(bookItem.getId());
            PostedBookEntity userPostedBook = postBookRepository.findAllByBookId(bookItem.getId());
            String userPostedPhone ="No Contact!";
            if (userPostedBook != null){
                userPostedPhone = userRepository.findUserPhoneByNativeQuery(userPostedBook.getUserId());
            }
            userPageCollectionResponseItem.setUserPostedPhone(userPostedPhone);
            userPageCollectionResponseList.add(userPageCollectionResponseItem);
        }
        return userPageCollectionResponseList;
    }
    public List<UserPagePostedResponse> UserPagePosted(Integer userId){
        List<PostedBookEntity> postedBookList =postBookRepository.findAllByUserId(userId);
        List<UserPagePostedResponse> userPagePostedResponseList =new ArrayList<>();
        for (PostedBookEntity item :
                postedBookList) {
            BookEntity bookItem = bookRepository.findAllById(item.getBookId());
            UserPagePostedResponse responseElement =new UserPagePostedResponse();
            responseElement.setBookId(bookItem.getId());
            responseElement.setPostedDate(item.getPostedTime());
            responseElement.setBookPrice(bookItem.getPrice());
            responseElement.setBookTitle(bookItem.getTitle());
            responseElement.setPublishYear(bookItem.getPublishYear());
            userPagePostedResponseList.add(responseElement);
        }
        return userPagePostedResponseList;
    }

}
