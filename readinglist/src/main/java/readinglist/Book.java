package readinglist;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //It’s annotated with @Entity designating it as a JPA entity.
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	/*
	 * The id property is annotated with @Id and @GeneratedValue to indicate that 
	 * this field is the entity’s identity and that its value will be automatically provided. 
	 */
	private Long id;
	private String reader;
	private String isbn;
	private String title;
	private String author;
	private String description;
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
	public String getReader() {
	return reader;
	}
	public void setReader(String reader) {
	this.reader = reader;
	}
	public String getIsbn() {
	return isbn;
	}
	public void setIsbn(String isbn) {
	this.isbn = isbn;
	}
	public String getTitle() {
	return title;
	}
	public void setTitle(String title) {
	this.title = title;
	}
	public String getAuthor() {
	return author;
	}
	public void setAuthor(String author) {
	this.author = author;
	}
	public String getDescription() {
	return description;
	}
	public void setDescription(String description) {
	this.description = description;
	}
}
