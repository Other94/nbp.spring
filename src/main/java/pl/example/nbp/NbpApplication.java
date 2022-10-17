package pl.example.nbp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.example.nbp.service.DownloadUsd;

import java.io.IOException;
import java.time.LocalDate;

@SpringBootApplication
public class NbpApplication {

	public static void main(String[] args) throws IOException {


		DownloadUsd downloadUsd = new DownloadUsd();
		downloadUsd.downloadUsdRate( 2);

		SpringApplication.run(NbpApplication.class, args);
	}


}
