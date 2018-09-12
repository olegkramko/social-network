package coding.twitterclone.domain.repos;
import coding.twitterclone.domain.domain.Message;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {
    //messages search
    List<Message> findByTag(String tag);
}