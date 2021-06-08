package APIFullstack.websachcu.Service;

import APIFullstack.websachcu.Entity.CollectionEntity;
import APIFullstack.websachcu.Repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository collectionRepository;
    public Integer runUnlikeAndLikeStatus(Integer userId, Integer bookId){
        if (userId ==null || bookId ==null){
            return 0;
        }
        CollectionEntity collectionEntity = collectionRepository.findByNativeQueryUserAndBookId(userId, bookId);
//        Integer likeStatus =collectionEntity.getLikeStatus();
//        likeStatus = Math.abs(likeStatus-1);
        collectionEntity.setLikeStatus(0);
        collectionEntity = collectionRepository.save(collectionEntity);
        return collectionEntity.getLikeStatus();
    }
}
