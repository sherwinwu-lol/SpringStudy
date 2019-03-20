import com.wusd.readinglist.ReadingListApplicationTests;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebAppConfiguration
@SpringBootTest
public class MockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {

    }

}
