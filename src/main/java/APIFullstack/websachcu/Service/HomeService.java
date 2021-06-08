package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Controller.Request.HomeRequest;
import APIFullstack.websachcu.Entity.BookEntity;
import APIFullstack.websachcu.Repository.BookRepository;
import APIFullstack.websachcu.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public List<BookEntity> runHomeService(HomeRequest homeRequest){
        Integer pageSize =8;
        Sort sort = Sort.by(Sort.Direction.ASC,homeRequest.getOrderBy());
        if (homeRequest.getDirection().equals("DESC")){
            sort = Sort.by(Sort.Direction.DESC,homeRequest.getOrderBy());
        }
        PageRequest pageRequest =PageRequest.of(homeRequest.getPageNumber()-1,pageSize,sort);
        List<BookEntity>  homeBookForms = new ArrayList<>();
        if (homeRequest.getCategoryIde() == null){
            homeBookForms =bookRepository.findAllBy(pageRequest);
        }else {
            homeBookForms = bookRepository.findAllByCategoryId(homeRequest.getCategoryIde(),  pageRequest);
        }
        return homeBookForms;
    }

    public HomeRequest countTotalPages(HomeRequest homeRequest){
        //      Tinh totalPage.
        Integer pageSize =8;
        double totalItemsCount;
        if (homeRequest.getCategoryIde() == null){
            totalItemsCount = bookRepository.countTotalItemsNativeQuery();
        }else {
            totalItemsCount = bookRepository.countTotalItemsByCategoryIdNativeQuery(homeRequest.getCategoryIde());
        }
        Integer totalPages=(int) Math.ceil(totalItemsCount/pageSize);
        if (totalPages != null){
            homeRequest.setTotalPages(totalPages);
        }
        return homeRequest;
    }

    public List<Integer> getPageNums(Integer currentPage, Integer totalPages){
        List<Integer> pageNums =new ArrayList<>();
        if(currentPage !=1){
            Integer previousPage = currentPage-1;
            pageNums.add(previousPage);
        }
        pageNums.add(currentPage);
        if (currentPage!=totalPages){
            Integer nextPage =currentPage +1;
            pageNums.add(nextPage);
        }
        return pageNums;
    }

}
