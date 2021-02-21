package spring.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import spring.transactions.service.SingerService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"spring.transactions.*"})
public class DemoApplication implements CommandLineRunner {

    private SingerService singerService;

    @Autowired
    public DemoApplication(SingerService singerService) {
        this.singerService = singerService;
    }

    @Autowired
    public void setSingerService(SingerService singerService) {
        this.singerService = singerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(singerService.countAllSingers());
    }
}
