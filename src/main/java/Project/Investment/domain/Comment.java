package Project.Investment.domain;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Comment {
	
	private Long id;
	private String username="Ananomous";
	private String text;
	
	private Set<Reply> replies=new HashSet<Reply>(0);
	
	
	
	
	private LocalDate date;
	private LocalTime time;
	
	
	
	
	
	
	
	public Comment() {}
	
	public Comment(String username, String text) {
		super();
		this.username=username;
		this.text=text;
		
		
	}
	
	

	@Column(name="text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="date")
	@CreationTimestamp
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Column(name="time")
	@CreationTimestamp
	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@ManyToMany(cascade = CascadeType.MERGE)
	@JsonIgnore
	@JoinTable(name = "comment_reply", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "replyid") })
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	
	public boolean hasReply(Reply reply) {
		for (Reply commentReply: getReplies()) {
			if (commentReply.getReplyid() == reply.getReplyid()) {
				return true;
			}
		}
		return false;
	}
}