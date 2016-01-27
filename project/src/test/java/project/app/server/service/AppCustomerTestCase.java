package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.AppCustomerRepository;
import project.app.shared.customers.AppCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import project.app.shared.customers.AppCustomerCategory;
import project.app.server.repository.AppCustomerCategoryRepository;
import project.app.shared.customers.AppCustomerType;
import project.app.server.repository.AppCustomerTypeRepository;
import project.app.shared.contacts.CoreContacts;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.location.Address;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;
import project.app.shared.contacts.CommunicationData;
import project.app.shared.contacts.CommunicationGroup;
import project.app.server.repository.CommunicationGroupRepository;
import project.app.shared.contacts.CommunicationType;
import project.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("n5PwkWrIevZsSwedj5IiySZsHjGc5ZTjGLx3TKzpWzkprWhYQ9");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("ux744cfKNpNCAMA6OUz0icNV0Z7pafq59HPZLVQM3DV1NZByyd");
            appcustomertype.setDefaults(0);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(79);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("6VF5VvQvgY4WTLlH0fQZtAwEyBiUXTrxW0sMVZOyFrFAQ5V3HG");
            corecontacts.setFirstName("7sMhmf0oZOId6VlrNtd8BDGqvWRbgfm5tALJ7Yw0Qm1S14cqR1");
            Gender gender = new Gender();
            gender.setGender("6FFoe0a2AekJz5CfDYDWlJlAUhajktnS2388ri4lxqNESw88Iu");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("V6");
            language.setAlpha3("zo1");
            language.setAlpha4("qhYE");
            language.setAlpha4parentid(0);
            language.setLanguage("Y9LBHmWNo4UVrruQXABz2GmNmR3VxJ1iK87UudAyg4FBbASEb1");
            language.setLanguageDescription("cxOBCpoBaYcGAVHaI6QVXHQcJf1h6cxpm0YZUFcyXBTtqpQhEW");
            language.setLanguageIcon("g10A2jS0CESGVjzrNnplSwMTbi6fyWFdwYzYKj8sx8HF2PJyCl");
            language.setLanguageType("JlJXLoxXrO6Czq6VVGR39i2Wv1Bhya5h");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("zJ4eN6I079gORhIKNWG9XhVPNem1JXo8ZYIYBCjkOUpY5XJJ4x");
            timezone.setCountry("kzuF5KKFfmrsx7waaHwbRyTEpL3iNAEOnIR5wTuCkwK0xdtvYz");
            timezone.setGmtLabel("Vprq50f7ynOFhUsMVuHkhXCFMn7Iyny4UTa2yhxTh7fyCyaEhG");
            timezone.setTimeZoneLabel("8A3DxMpemhQSuMRM1BVJDmwrmUZIIqRf03xmdNSch2mnbwH9C9");
            timezone.setUtcdifference(9);
            Title title = new Title();
            title.setTitles("EOrZVNOnCKigZE0xdMERoyvNI768hb6kDgdtcYPpGAkBwOreRP");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(87);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("NhYURDnMyGNCiFg5nntHD2IUayMOjswSTElXehXjEndSkowY2g");
            corecontacts.setFirstName("yJ2YZVSZhLsH8nRRRpjtBFLNUJOkr87Qe04D1v2QwqvpeCUvBJ");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("1OqrKfoYMD8GC1XRGhTvpNtKiFlGmgjcVJtntjtqLMR49HJAXg");
            corecontacts.setMiddleName("1dyNI4iRXRRxGZ1FbfhlXlZn3Rdx1baxb8owUA7gtzqabukKhp");
            corecontacts.setNativeFirstName("eieGSJrqwXoa7PEzxOFGcXw7Dm3iB4CiY9UVwWlkMJoCIDWw0d");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("om5UeZfDq6pUdPl0XK1zDzntDskyJIyfhoaBKgllyeQg3FqK83");
            corecontacts.setNativeMiddleName("9BXEze0eRkOJu7trrqrer6rhYcknRegfCJUCNFFLYDK7FF77XE");
            corecontacts.setNativeTitle("qV5pmf82nWls9YZDEfNyfSIo0lArJ6E5l79CvxwKSLhPy3DQ8W");
            corecontacts.setPhoneNumber("NctHbhihkdIY45Ifcdvi");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("WY6ebCA7JtUQZ296JMvdqB5qMF1HSmhsRdhVme6FyIQndJNILX");
            address.setAddress2("my5TD5dlk0zRpYpf0cnF9LfX33pxxcZl6E5mwCuL4k9tHBIyWf");
            address.setAddress3("XskVdFKirB3BlLMcSGAiBzsieTwJctwxZWvCGoqDhRqfPKCW59");
            address.setAddressLabel("tXPpcvbJGk8");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("g0lTF3Sq9DhTVc7u94CL1x17mETlMBx6EZDBirE7Y1U7BeXPP6");
            addresstype.setAddressTypeDesc("VEZpk9QebdGUewLNu8bXF9GASkPWq3Sqg5sl4k7m6x298IPIts");
            addresstype.setAddressTypeIcon("UoDDAVPYRQoj6X0Ii3gMxTwh3s2JSnp9B203KZemnUxGR5hbxk");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("mhef5wTJSJ3g3veJQ0DFN89cpZwbw4WP");
            city.setCityDescription("jzgWTFBPqdTiWokdAuBrR0o0ydojBNHWBPPxcYpiuOmOVDS14Z");
            city.setCityFlag("PuuMbqWg4WDKfJ6FZQ3Pdw6JUZ7aEurfmPb6DW5laFOony0kJD");
            city.setCityLatitude(1);
            city.setCityLongitude(10);
            city.setCityName("DHyjv7qyeVcjRWQmQ5JDAn6TzTspO7fmNkHUtipfl6z68aEEmj");
            Country country = new Country();
            country.setCapital("3EYeQ0TDuShg1PDpeG4px4JBr9P6vFKv");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(2);
            country.setCountryCode1("SOx");
            country.setCountryCode2("68U");
            country.setCountryFlag("BrDLyAkl1o45opBd0oWWP2fcJxrfr30GKodcrcdeV2hhc8dqZc");
            country.setCountryName("bpLZBmQzDPpZoUoY3EWdWETVEFAPLbAoiNDFW7a8VnaPWHl7ar");
            country.setCurrencyCode("J9Z");
            country.setCurrencyName("KRaDY2EswZIhMb4qcr7ifLO7N265JEZwd1S8DzD3wDxmuC6fA1");
            country.setCurrencySymbol("wpjK5W4Vx8aEVbH34bXbhA1bjFvMEZEX");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("8hOTk7YJKQKSp6v32VoKs04TTvveuunKYV6BZJJVHWJ7LP6AvY");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("BBSAjSeCRcI752MI1nAx67q5vITYBBkS");
            state.setStateCodeChar3("Anqcjz1qjgLlxIl8HhMtvEbgzuiZfWNQ");
            state.setStateDescription("vws5BItUp15Q27s6mzBenSEsbt7Ao1dlOa4l1JSr1U7NRVXKQK");
            state.setStateFlag("Fy5v9mtuYgvnFK0IIIafkVZ37l5KtRl0BTu7U5IP9bol4EHLDQ");
            state.setStateName("tjaR0chw1B7HI7fbFSlWSg2gtEWe05pKLbFNVi292L9138NCgi");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("1uAD7TdH9T8ZqdsQgCPljkQxjhjAw12M");
            city.setCityDescription("Xc1aSldndm7RhcJxFmFJVYoYEAe5ImZ4CKwIFgi6bM6F4DIhlE");
            city.setCityFlag("plkIlBeTaDR7C14526IcJSQaTCLQ6EA8UoCBMDRJWoy68oVUHH");
            city.setCityLatitude(5);
            city.setCityLongitude(8);
            city.setCityName("nkVs9qJrr1avT0sg907GN36PknEzQe4RSxVGxqT8XyHKdJwaG7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("JUr6Qsi0G4xqJeIKXMvB19RAoKlfrrOQhTfeVPjKY8SnzPPG8B");
            address.setAddress2("mzx7AGeLKZJjILykuchFQalgLpbi6gYGlCXOFbcKxptFgJylHc");
            address.setAddress3("JjdbxBnLskjSqenZKr34hzzW2QCfaGbqFbENELima5JPZVTbQp");
            address.setAddressLabel("PnAQxTQ4RZY");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("uqlyjZYURPIk2iPQ8jqbEI6G6RuYTJQ6N0X5nd53hyG1F95Dy4");
            address.setLongitude("i59Bem1n8rCKUT47a2eqlAXMjoyToGDdCrziDs7adfld9kjcoi");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("RYqkf3");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("1");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("PSADxDwQWp17W7Y9hW2j1vzwSDRjt2Lt3SXTrxHip29uPvSV8W");
            communicationgroup.setCommGroupName("1E6VWndVHxi1BLWMLBpc2HzrH9dxv0cHtHsWTaziVFPXzh0OWr");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("lrltyyBoqcbk7Lx3cnUls4F4r82H8NnVVlo5a596xdxDE2ENVE");
            communicationtype.setCommTypeName("DcA9MZGneiYtc8VbUyteTyEcFYmwfKTeEl93isLLc4ucE1Zews");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("V");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("FDMqYZ7OgQsSfCseowp5FdfbDrkOnPsPxcmhZNdjq24pe3RpHE");
            appcustomer.setCustomerStatus(1);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("3TSQdY1ANgMoHCfnmYzX1BghOn5cvuy8BxzfEAy0a8zkpQVgXC");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
