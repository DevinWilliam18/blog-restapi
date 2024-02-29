package com.example.demo;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.model.Friendship;
// import com.example.demo.model.Role;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.repo.CommentRepo;
import com.example.demo.repo.FriendshipRepo;

// import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


//   @Bean
//   public ApplicationRunner initData(FriendshipRepo friendshipRepo, UserRepository userRepository, ArticleRepo articleRepo, CommentRepo commentRepo) {
//		return new ApplicationRunner() {
//
//			@Override
//			public void run(ApplicationArguments args) throws Exception {
//
//				try {
//					// Role role = Role.builder().name("ADMIN").created_at(new Timestamp(System.currentTimeMillis())).updated_at(new Timestamp(System.currentTimeMillis())).build();
//
//					// roleRepository.save(role); causing detached entity
//
//
//					User user = User.builder()
//									.fullname("Devin William")
//									.email("vins@gmail.com")
//									.password("1234")
//									.username("devin9023@gmail.com")
//									.createdAt(new Timestamp(System.currentTimeMillis()))
//									.updatedAt(new Timestamp(System.currentTimeMillis()))
//									.build();
//
//					User user2 = User.builder()
//									.fullname("Eko Khan")
//									.email("khan@gmail.com")
//									.password("khan_1234")
//									.username("eko24@gmail.com")
//									.createdAt(new Timestamp(System.currentTimeMillis()))
//									.updatedAt(new Timestamp(System.currentTimeMillis()))
//									.build();
//
//
//					userRepository.save(user);
//					userRepository.save(user2);
//
//
//					Friendship friendship = Friendship
//												.builder()
//												.from(user)
//												.to(user2)
//												.createdAt(new Timestamp(System.currentTimeMillis()))
//												.updatedAt(new Timestamp(System.currentTimeMillis()))
//												.build();
//
//					friendshipRepo.save(friendship);
//					
//
//					Article article = Article.builder()
//											.title("Java Framework")
//											.description("adasdadadjakdjajd")
//											.state(State.PUBLISHED)
//											.user(user)
//											.created_at(new Timestamp(System.currentTimeMillis()))
//											.updated_at(new Timestamp(System.currentTimeMillis()))
//											.build();
//
//					articleRepo.save(article);
//					
//					Comment comment = Comment.builder()
//											 .commentBody("great article")
//											 .article(article)
//											 .user(user)
//											 .created_at(new Timestamp(System.currentTimeMillis()))
//											 .updated_at(new Timestamp(System.currentTimeMillis()))
//											 .build();
//					commentRepo.save(comment);
//	
//
//
//				} catch (Exception e) {
//					logger.error("Error: {}", e.getMessage());
//				}
//				
//			}
//			
//		};
//   }

	
}
