package project.app.server.businessservice.defaultcontext.defaultdomain;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.app.server.repository.TestEntityRepository;
import project.app.shared.defaultdomain.TestEntity;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import project.app.shared.defaultcontext.defaultdomain.TestDto;

@Component
public class NewService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TestEntityRepository<TestEntity> testEntityRepository;

    public void newMethod(TestDto newDto) throws SpartanPersistenceException, Exception {
        if (newDto.getTestName() != null) {
            project.app.shared.defaultdomain.TestEntity testEntity1 = new project.app.shared.defaultdomain.TestEntity();
            testEntity1.setTestName(newDto.getTestName());
            project.app.shared.defaultdomain.TestEntity testEntity2 = testEntityRepository.save(testEntity1);
        }
    }
}
