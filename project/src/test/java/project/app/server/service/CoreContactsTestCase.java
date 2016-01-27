package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.CoreContacts;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("F1MHFOQFlgCIIA6YA5QYeo20ivUoakUxP2fUpjcdKFPNCiu768");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("hi");
            language.setAlpha3("qpI");
            language.setAlpha4("KVYl");
            language.setAlpha4parentid(2);
            language.setLanguage("3zcBYS1QOVhiAjutA8eD9jR2p6mo4bBi2LR06rcscMGUBoQfzK");
            language.setLanguageDescription("uZYYHV8K3ZXpwVRDaO79uXnQcs7dde8IvM3PCMvqqLBAwCJsRp");
            language.setLanguageIcon("hFCqXuVyWVmpuDTU42LeAAZm6QB0I9Csru7Gl1IUItCtf5gYBd");
            language.setLanguageType("Z8cmL4PiozvU7RWotj2yxVMl3IBEVDik");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("dXZJxXZdLxm1V1Fy6ZALMS3P89r2OMCZVYRnb22r3MvPGauHl1");
            timezone.setCountry("BYAWYYd9tPs1McAlvInwekSSQ8XO6pih9qbzxQ5wIv6VRsz2h0");
            timezone.setGmtLabel("fNIEKvTwQg8WgIB5qeUnJnGIgcHiYq7fRWlEKTC6hDrVqAyZy7");
            timezone.setTimeZoneLabel("ID8E0mKNbCKrSLvmJZsE2BQGwpb7wAnpASHWC4h0zt7PCT75fI");
            timezone.setUtcdifference(8);
            Title title = new Title();
            title.setTitles("XA2p2ipjCFnPfpqqxzYmez8SkSv9z4AtfqyOC5CB4SzUx9KXXc");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(52);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("QnyhPbkxU6th1Bw5CnFElYNWGyi7aUOV8rX60yVwJ3rLPwckQS");
            corecontacts.setFirstName("rrH3jrHZHNVqLPxlQIKREb8ezzpMH7U3atuuJMpAAjdcHGfEjM");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("cx8VwxI3Yrtr4qBSLa44Ovd691T5SL56nO9hMmslo3oHd9woQo");
            corecontacts.setMiddleName("CjDPxbgbhFOIr9dSBuZXaJ9sJAiAb4KvYWlEygv74k9JRDBHzH");
            corecontacts.setNativeFirstName("ebk8jCDkmKNACh49fIuuxdHRpKOjBdT7et1fXPijkIAv8eiS1o");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("N1YO80yi7lmc6asicmlUCeoC3pfQra4LhuXkgTYtc5egcg6G3U");
            corecontacts.setNativeMiddleName("t5O0ncTfNF81167Vp021IyGwcG9rwxrwvOsV8ncE2jgqagwNnH");
            corecontacts.setNativeTitle("zoW3QH8hdvJ1KcqhaeD077mTb9fTldwFwgGnVBoAdrv0FGVmO2");
            corecontacts.setPhoneNumber("68SX6HEBfMqbtWwlQjTm");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("VyxePMLDHNz6cz5MkwEcvgi3Hx81RnVAQ2NWajjMbwtENBwWSz");
            address.setAddress2("9eZTWyU5yUMGtlfqzmyIrqeOFD4qJIdGFZR2p2OS42e6u9GB9F");
            address.setAddress3("nIyIqpDJEiRYObaNGwJsP3NUvz07POUEtjrCgYA33tDoVzjjy6");
            address.setAddressLabel("VBosX5NX2sT");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("v8tyxZmUgEwPsokUWGQxBGaDizqxzLUdB00QvCEZQ6qeS5KQrt");
            addresstype.setAddressTypeDesc("FSGgBpM4CefE7NomIC4rxyh7rmk65PzguKGUQswoISRIB1ktg4");
            addresstype.setAddressTypeIcon("UfHTX90U3Xi33ONmMufAcQQZIPcEx4xfappBI12bl4EsZWPR2m");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("WBudkQFeoWr2YZmO6G4VNwBotHgcz3Ow");
            city.setCityDescription("gnOpaOpTABxuoIpjwJb6Q30JrnIvdlJSPmq3GLTmeJ5c1TKQle");
            city.setCityFlag("r4GWXBz2RYfV5pXlITV8qLRWmtV3E8dbuvp8Aoj3qRYqs5z8ti");
            city.setCityLatitude(6);
            city.setCityLongitude(8);
            city.setCityName("b8QqGVGA8d0ZRYTMFUhQVLRZMHpU9HNsJgk3NzcIoqvhY3pV1j");
            Country country = new Country();
            country.setCapital("DBT3Dv2ar1tiGp74V7V0ZNjekqfkmUYP");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(9);
            country.setCountryCode1("QNR");
            country.setCountryCode2("Juw");
            country.setCountryFlag("nbPY8b4a1M8JuMsvsi4h52Ay0i53IA5IqYH2vJKXl9RNRlDh0T");
            country.setCountryName("JCgXPLOnw2JKzhPb6rMO1uNZdo1TCDn9rH5nA8YNlk45QEgCpV");
            country.setCurrencyCode("QjQ");
            country.setCurrencyName("aawDfPmdk9VdvFLInnzZE6haJk2rs9PIRnkjeYz2R6S03P5jes");
            country.setCurrencySymbol("AJiPqQKBfIS2kAtaIcbhkN3mC6RC2bj9");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("fhrzDCQyEsdIjxFsb5CGqwIpIuW7WjA3KdUFKKrHssJQOtHl78");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(2);
            state.setStateCode(0);
            state.setStateCodeChar2("M82B64xkJNx1c8mU9WDxfAL32fq5bzoP");
            state.setStateCodeChar3("R3ouyAe82s6QACw3kBKChTKDca5fDrtD");
            state.setStateDescription("9IuDc1c8qpj1EECYP7lV7XoBpiUryBCbhNhsmqxYYLr9CKnyKp");
            state.setStateFlag("DiH8CyUK4TEKmHHBXYw1Q0JZRzg3LidcQyy3leR3VkLIQzrzkF");
            state.setStateName("SkpC3xYCkTtcdgKW4DUP82rjENaKF0srdMA2CE7vlEB3gBtIZ8");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("x4k5Bq6VoKbfN1ySgxA6KyxqOrUdOkEU");
            city.setCityDescription("NXHPxeLRyYVWVWAo74pqU7Gly9dff2LxbP6XVmXFvIfBA1vD1L");
            city.setCityFlag("Lx4siUWwMzgEGPDkx3b3hua27q2zeMbPTrcZ3KHNOa5O7ccaoI");
            city.setCityLatitude(9);
            city.setCityLongitude(4);
            city.setCityName("LJp2luKVQIiW8dN9WJPge8r5cA5ffsWOVAmsNk4oVsnihLv3YZ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("JgGaEtMkpK3spmZU4afz8H3jJljj00C7UBYwgNVg6YNXyzdmcG");
            address.setAddress2("mdJ25OFdFyUvullhCP9Cn5itPzq9cbt9namMVIYUEko9DwusPM");
            address.setAddress3("cDg4nN99Ln43zF6WxlqoUwVQanvQkG8UEninrdcV8IFBhKQONa");
            address.setAddressLabel("vQZWDcomhtJ");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("G62S7Ex9l5eoHlAdUiw2ut343PSALU65fMcrJyUYUVRH3UROMt");
            address.setLongitude("yUMpS5Y2IUClZf6d4wYZ8A6IDIYcEPw3ijf3PboCXkxXkmMPrr");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("ZjJLYC");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("Q");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("lfNYzFm0JGuPgNr04oRMX3qFTxH5N3vcsumF8M7kKfSPQ1xbxL");
            communicationgroup.setCommGroupName("uHYU4aXpj7eFMp9rG2KcgMm7HMqR0kJ17BpMWRNgV9z8QZ94uP");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("QvCxsgviT0PGLkQIgIEsOlRIhLkcekCHzkmleQ6lTYe11Y0Ezj");
            communicationtype.setCommTypeName("IvQuzOnK0VPsjuFoqRqDeILNwdm3OyILjxXXAoDoKvcya3J6I9");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("8");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(43);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("exybL8KhAWLdISiTFO244GALdUCaGCbacxdn4CgONkIHpHiaiQ");
            corecontacts.setFirstName("1lqYKTMbFlxQoaFVFh9KhXNvKvKJOnVXAanQSGArfdPVUm1iaj");
            corecontacts.setLastName("Ye8DZLyFYB6jKLPNMFswLJokk2sqoe4k6i8kDf7Xu113zoJWMa");
            corecontacts.setMiddleName("ZFmHxxNRSt0RTb09TuLasa1DGJ0Aw9rvksxVUxpq5Fvwqe9Kz0");
            corecontacts.setNativeFirstName("HmnWtGNrkHisFNX3WKlCTJcTqHdDMVB3n3qkPhpAbWZHCTDYsv");
            corecontacts.setNativeLastName("j5qyroJzXr61iWy7OkIYuWeNbm73SSZq0fUf7nKzoPOC3VcVpy");
            corecontacts.setNativeMiddleName("TBfYEoJPltNYZBemkR3TZ7k98wLP7wSspbFE76O4AkJdORgkxJ");
            corecontacts.setNativeTitle("9VQbchfD8qH0xgTzCPbDqUGDWA42CtWBUwN1blaJNJMBqGNyCx");
            corecontacts.setPhoneNumber("5JzYjgrv53yZY979wEKk");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
