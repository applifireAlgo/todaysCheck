package project.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import project.app.shared.location.Address;
import project.app.shared.contacts.CommunicationData;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "puja.singh@algorhythm.co.in", updatedBy = "puja.singh@algorhythm.co.in", versionNumber = "2", comments = "Repository for CoreContacts Transaction table", complexity = Complexity.MEDIUM)
public interface CoreContactsRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void deleteAddress(List<Address> address) throws SpartanPersistenceException;

    public void deleteCommunicationData(List<CommunicationData> communicationdata) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public List<T> findByTitleId(String titleId) throws Exception, SpartanPersistenceException;

    public List<T> findByNativeLanguageCode(String nativeLanguageCode) throws Exception, SpartanPersistenceException;

    public List<T> findByGenderId(String genderId) throws Exception, SpartanPersistenceException;

    public List<T> findByTimeZoneId(String timeZoneId) throws Exception, SpartanPersistenceException;

    public T findById(String contactId) throws Exception, SpartanPersistenceException;
}
