package Project.Investment.domain;

import java.util.Set;

import javax.persistence.*;


@Entity
public class Reply {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long replyid;
	
	@Column(name="replyusename")
	private String Username="replyusername";
	
	@Column(name="replytext")
	private String text;
	
	@ManyToMany(mappedBy = "replies")    
    private Set<Comment> comments; 
	
	public Reply() {}
	
	public Reply(String username, String text) {
		this.Username=username;
		this.text=text;
	}

	public Long getReplyid() {
		return replyid;
	}

	public void setReplyid(Long replyid) {
		this.replyid = replyid;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	

}
