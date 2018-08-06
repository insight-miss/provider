//package test;
//
//import com.weke.provider.ProviderApplication;
//import com.weke.provider.domain.AccountInfo;
//import com.weke.provider.repository.ElasticCatalogRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProviderApplication.class)
//public class AccountTest {
//
//    @Autowired
//    ElasticCatalogRepository repository;
//
//    @Test
//    public void testAdd() {
//        AccountInfo info = new AccountInfo("1", "www", "xxxx");
//        repository.save(info);
//    }
//
//    public void getAccount() {
//        System.out.println(repository.findByAccountName("www"));
//    }
//}
