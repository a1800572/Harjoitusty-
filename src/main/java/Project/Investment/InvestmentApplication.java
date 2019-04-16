package Project.Investment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Project.Investment.domain.Comment;
import Project.Investment.domain.CommentRepository;
import Project.Investment.domain.Metal;
import Project.Investment.domain.MetalRepository;
import Project.Investment.domain.Metaltransaction;
import Project.Investment.domain.MetaltransactionRepository;
import Project.Investment.domain.Metaltype;
import Project.Investment.domain.MetaltypeRepository;
import Project.Investment.domain.ReplyRepository;
import Project.Investment.domain.User;
import Project.Investment.domain.UserRepository;






@SpringBootApplication
public class InvestmentApplication {
	private static final Logger log = LoggerFactory.getLogger(InvestmentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InvestmentApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner comment(CommentRepository crepository, ReplyRepository rrepository, MetalRepository mrepository, MetaltypeRepository mtrepository, MetaltransactionRepository trepository, UserRepository urepository) {
		return (args)->{
			log.info("pari kommentia");
			
			mtrepository.save(new Metaltype("Gold"));
			mtrepository.save(new Metaltype("Silver"));
			mtrepository.save(new Metaltype("Platinum"));
			mtrepository.save(new Metaltype("Palladium"));
			
			trepository.save(new Metaltransaction("Buy"));
			trepository.save(new Metaltransaction("Sell"));
			
			//testi metallit
			mrepository.save(new Metal(12, 0, mtrepository.findByType("Gold").get(0), trepository.findByOperation("Buy").get(0)));
			mrepository.save(new Metal(3, 0, mtrepository.findByType("Silver").get(0), trepository.findByOperation("Sell").get(0)));
			
			
			//testi kommentit
			crepository.save(new Comment("Pekka","aaaaaaaaaaaaaaaaaaaaaa"));
			crepository.save(new Comment("Vilma","bbbbbbbbbbbbbb"));
			crepository.save(new Comment("Juho","ccccccccccccccccccccc"));
			
			
			User user1 = new User("käyttäjä", "$2a$12$KDF4TyXvkV9D/sp1K0VZY.ml/ZilUgn1DfMDR/d.iukHoi6s3JCbi", "valtteri.koivunen@hotmail.com","566654344", "USER");
			//user2 salasana on bookstore
			User user2 = new User("admin", "$2a$12$pL0lx/TRYFjNvX30hmJX7u7WJ3UALMWxztTpE9dylI5nuyC2L.VOi", "admin@hotmail.com", "6767474734", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			
			log.info("nouda kommentit");
			for (Comment comment : crepository.findAll()) {
				log.info(comment.toString());
			}
			
			log.info("fetch all metals");
			for (Metal metal : mrepository.findAll()) {
				log.info(metal.toString());
			}
		};
		
	}

}
