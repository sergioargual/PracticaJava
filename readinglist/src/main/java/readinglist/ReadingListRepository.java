package readinglist;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//The interface will be implemented automatically at runtime when the application is started.
public interface ReadingListRepository extends JpaRepository<Book, Long> //By extending JpaRepository, ReadingListRepository inherits 18 methods for performing common persistence operations.
{
List<Book> findByReader(String reader);
}