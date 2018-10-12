package coding.twitterclone.domain.repos;
import coding.twitterclone.domain.domain.Message;
import coding.twitterclone.domain.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageRepo extends CrudRepository<Message, Long> {

    Page<Message> findAll(Pageable pageable);

    Page<Message> findByTag(String tag, Pageable pageable);

    Page<Message> findByUser(Pageable pageable, User author, User currentUser);
}