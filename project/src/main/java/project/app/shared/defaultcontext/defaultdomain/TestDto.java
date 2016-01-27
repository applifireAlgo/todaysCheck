package project.app.shared.defaultcontext.defaultdomain;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestDto {

    private String testName;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String _testName) {
        this.testName = _testName;
    }
}
