package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.LoginRepository;
import project.app.shared.authentication.Login;
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
import project.app.shared.authentication.User;
import project.app.server.repository.UserRepository;
import project.app.shared.authentication.UserAccessDomain;
import project.app.server.repository.UserAccessDomainRepository;
import project.app.shared.authentication.UserAccessLevel;
import project.app.server.repository.UserAccessLevelRepository;
import project.app.shared.authentication.PassRecovery;
import project.app.shared.authentication.Question;
import project.app.server.repository.QuestionRepository;
import project.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(20);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("0gXENg4gaVbOVPpXb9VWUvhCB16xZQYt74S2dK2njlJQbfpaSK");
            corecontacts.setFirstName("Q9fy7qHDCuXfjjEhL6b5VpOs3oofcyQsYwA2YJh7MiIGZacQ0u");
            Gender gender = new Gender();
            gender.setGender("pbtJWHJhnSTsGKXhO3W3PphgYyliIfZ0eODxSWY1DrT15ULuL1");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("M2");
            language.setAlpha3("3k0");
            language.setAlpha4("IGsP");
            language.setAlpha4parentid(1);
            language.setLanguage("7UXtRGsOpC9Xl9i5CP6U0Rep7u530kYSO4XB2SRgsFm4ZlPcC4");
            language.setLanguageDescription("wL1ge50pQlVMORBvBSqxHW4cgcXdfhoLixK1L7I5nQG94B0w0Y");
            language.setLanguageIcon("GeiMKZzKopBAqMpFMz2gtwvUbbhRxUuIp2pamQbYbPYoXa32TV");
            language.setLanguageType("CyByejzC0VAD2Wd9lAeWIRIvdvcNdZHM");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("ijOVP7KDx1TUpy5cLdg6o1KBtb0oljl4T8KSzpLFbiLIsswVGK");
            timezone.setCountry("lBrCAIJsvhhr6wzKUDXKp0hILMBVDkAfBiafwcEBRxJlWg0NKr");
            timezone.setGmtLabel("DJx5DXZw1uUb1MGgCz6d6aA6AS4L26YEEiMYgyEN7kaPtNPfL1");
            timezone.setTimeZoneLabel("XpOg32UaTzGvur0lGHiBnsfcwo9Sp4wpP4LusiFasw3c6laTgT");
            timezone.setUtcdifference(11);
            Title title = new Title();
            title.setTitles("BqQk05L8aPqnFKqw3DeISfdepcJfnP64EOy0F1EuK5VzWuigAL");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(69);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("4iqvzoVXcqNE7VBFDhXWfSTlfRcGHZZonXMsyR0L0bvToeDQDV");
            corecontacts.setFirstName("xrZhNhGWBpU3IEKPZJFLsPFydPO5XRHlGJIG48JbhEZZ6smd9Q");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("17gXDUtf3xTVz5QMlRbp7UBRGtkvPhVuSZyvcB2pXiI21pbvpr");
            corecontacts.setMiddleName("osWwIhoX6Z6KuooqPFx9A4HrGvx7OOPVay0UUHRfocqa5CgGg5");
            corecontacts.setNativeFirstName("a5p01NwYdFHxQMIJUvQ6ou9aJvavO5FdYVXZUvcPnZxU0MNyqI");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("SjN2KfBz06Zb8mrvfyDZsgj3UttL6WDwXehiPbdpUfYCsqOEgb");
            corecontacts.setNativeMiddleName("B9zmzhk4yoG6o9T1fODNnn7qrSqoo3bfAVHUzYPLir340VjPAd");
            corecontacts.setNativeTitle("cWSqLaO8MpHMQTIhae5O2URZhf7XVqdRCv52sKTPsbmNbIPt8B");
            corecontacts.setPhoneNumber("EvXm7rSQEJq4EWGIQmso");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("Ip8hBY2hTC9ILz4b6sKiEOXZoi9WdqxNKQvpPq4qNQUZvfHv6D");
            address.setAddress2("NXML87gmkPso4CuIxuq0MFUY1mNRzVefPyMkEyx0LxRoM6amew");
            address.setAddress3("OKnEMT9IVkhzSQ1nzwL9IsNbA6iBqWU8v2hjCA8YFc6FqCly7S");
            address.setAddressLabel("prFrVCoHn2o");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("sWgDrAjHPtPBeVQRekC3MwpZMLvHzJjqaGzsu0EhDFw72ABoK0");
            addresstype.setAddressTypeDesc("REY0k0USsaj3R27MbKc7XTlqBK82rm1uK3GhXosRDXK5cIUIjS");
            addresstype.setAddressTypeIcon("Vd7wt7bNYfK7klcMoYtr9lxqGBy0U9Xizdk5ae4JiLacv1oxgl");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("asHvVtAEk1hkKmwtl7bCzi9tsQmFJwW3");
            city.setCityDescription("f3ZxQTtoyBxxQR5tovCYsz2f0RsKC6uhSS86ROHPhKQXY7Vxew");
            city.setCityFlag("uSyWr7pT2cUTCwiZ6rScIhR4E362QTJ4VNlvREbEYIUnm8RYpv");
            city.setCityLatitude(4);
            city.setCityLongitude(6);
            city.setCityName("jKfoqlbLvgrPOyJSo4CWEycZ5YunCcklvhwwMISA6pcjpxJ4CO");
            Country country = new Country();
            country.setCapital("ebVfbJL77NXAexVIkO64TJMtjWesHjzj");
            country.setCapitalLatitude(7);
            country.setCapitalLongitude(1);
            country.setCountryCode1("7Yh");
            country.setCountryCode2("ps4");
            country.setCountryFlag("vzixgctjWO0iIyLwpZZpnOFD39aG3KzSbDIniKsKHT3Vx20ShA");
            country.setCountryName("gLGKvmwyZvtdM67sjAyyHnIvYzSd82VZtw6DjFgzRl7xsznTKo");
            country.setCurrencyCode("0KN");
            country.setCurrencyName("rwlAccpu6rRf9XIMAblYWU6PK1GXuOZJKBqwJfEvc1T1qphdIX");
            country.setCurrencySymbol("IBwEyOK6UzFqfJI6H1UNadR73eNRYECY");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("3sBgtnLvY05X0R6q3sYRL7WVhwqrtxxxL402OP6GE7CWPp2tW0");
            state.setStateCapitalLatitude(10);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("EWGV9zQ9heBUq62Zl0V4GukDofE8zc10");
            state.setStateCodeChar3("IGZn02OcSO49BUXhO7AXu0jjjMzTk1u2");
            state.setStateDescription("0tKP7Xr9pRwoBh97CIoRLbPO4w0f9yyz59cnz05AruonfasGVL");
            state.setStateFlag("lEDWW5TzUnDImfVNT7BHdQcSgGG6FfBsR0PsEHk1nVauOvcKyx");
            state.setStateName("NI2Fi9sJ1lrn0wrveUvN5B17UCXj8uph1jBCU97PqWzfu59Jji");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("IBGB5L2WIU83exN99FzNhNqZ58azqhyz");
            city.setCityDescription("WavqSRz1tjre9zQtnoNPt7u5V7zvwP7l0rvfLank9grQtEoXPY");
            city.setCityFlag("qhfinTwZ2hcgkSO2DrpkQDKqCvvDuzX1ZVFbS8ZDtrBrYy17RC");
            city.setCityLatitude(4);
            city.setCityLongitude(11);
            city.setCityName("b6zqfNyoUlUn9X2QAjyNErAL1mkCWrkEzvicJn33Im6ImxQWmI");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("l5vOhUQjW7eMy2d2da6nEWOOfTJM5lCKSynp21a9p1P9urEcgS");
            address.setAddress2("WSxvA5hpyL8ywseYtozKOYI2yj4yeOhZljRfJk0XW90mbgqEYp");
            address.setAddress3("H32UketRuRtoTf9W4KmhQVaRp3WBOCbAGecpUeVZx8cXrO3iQW");
            address.setAddressLabel("QGm5QkcoQAt");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Nohephlpm6RXQZqiUf6VrxI3b43GPpR46D2aTsJms6zgAxa8ii");
            address.setLongitude("3xk9o3gex3QwDcYvHtLmlXpgf2CLW9aUpWdOtO3R3gqeDUXqbq");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("Medtca");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("T");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ddfM2RqGEaMVAKhaLVa05fnDASSWSx9P4FPGzxknDscdg3TZnj");
            communicationgroup.setCommGroupName("lPsCID5BbVVIziWKX5QNc6oGvIwxrUtr856So9cJ5RSkn9oqe4");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("M4mz0PuZCI9kdNbxnTMuFuhRK6oVKu7CDUZd5Twcjh61BeXkPu");
            communicationtype.setCommTypeName("wxOkp0Fw4q2oDJRFbD1UZBiYU3gO2oFjWDaHyJMQNoBJ9b4U0N");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("Z");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("SIA4BCwuBabpGqtjvrOBCzBkfDznePcgTZCogms2cbt1yodVim");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2445);
            user.setUserAccessCode(3);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("YK70rcTkyvoOd69Xa8f4TrGvVsFXxElUnaJuNuVvFbO6nPC3KY");
            useraccessdomain.setDomainHelp("htVYo8JIabB8eqLzfspokIV0h45JvR3rtrBoNxUwfuFcLAm9Dy");
            useraccessdomain.setDomainIcon("9bF93cSn4ndFzoBAzrFxK0TZ0da0EzPBBPNGC5FvZXphYFVd66");
            useraccessdomain.setDomainName("TrQrNQKAvHNWgDCzSSr4ofx5Wa2UA7aP0mxNuaOveXtGGVrGpT");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("ED6DzMqrJYOcS47DzyWehcFBax1fCGj2WB11pNHQc6RfNz49Pl");
            useraccesslevel.setLevelHelp("A8Qo1pBBZqx3ybPMxvObgZlSzMkI4Lfg7Ieu4uKXZei4trrEB6");
            useraccesslevel.setLevelIcon("smgjo63tOhDc3alosGadBApEqKv8YSl7rKiebR6VNXmA29MYCR");
            useraccesslevel.setLevelName("SpyE5Zk3LdeojSTVl6o5t2W7m023mot4RIThQtOC3LGZJPyFP0");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("Q6cBep3q7CXy3f8wIWhvsaUGYgh8hy3w9QOh0q9YyD2XQQa4DJ");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1503);
            user.setUserAccessCode(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("cBGr2hXOCrXOuDH4BqGuoQw324gTNIh0tXjS2PhTZ2OmScR2eU");
            Question question = new Question();
            question.setLevelid(6);
            question.setQuestion("sjuJEVXVUSTTB7hjI5wT9Rm82kXDqG8VjjRLdO307gKyF2kA7Q");
            question.setQuestionDetails("a");
            question.setQuestionIcon("Yt9hhkAAp1EVZdwhOUfyD0TBNHboq8amWkAsKhWXmzrdgxYGMh");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("1KoxZikTwh0BcHBV8VzHIrUwMeUo6nETRj9nmDuc7DY8qFCo0C");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("gE9SuOLp9DHAOFSEimC5kstDVczNWiemsY4UjyxFWrq9SyYt5t");
            userdata.setOneTimePassword("1VLf35YySl31HpWWVZoRb7OS4OVHqF1V");
            userdata.setOneTimePasswordExpiry(9);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("gtwGxxURJEntwPWbifUB038VRKQ7Fk2pbNgrs0SuJuvkyu4xyH");
            userdata.setLast5Passwords("G5kmMS0Bt7VjHH3s9yRg1k0aMdq3JoHSGUWvw9dQrw5Ug7KQXv");
            userdata.setOneTimePassword("DZRX9ZcIBZ46xqxTwWdPOSK8mtrMsT1H");
            userdata.setOneTimePasswordExpiry(8);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("RF6Jw9lfNJX5Y3VdVcMU6OCN3nruHqWWMMU2KFENhKgqkctmOc");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(7);
            login.setIsAuthenticated(true);
            login.setLoginId("xAB37oHcIuvo3RYf3J5vqRxR1lsT357fdfRX12BHQ0Hf585YZy");
            login.setServerAuthImage("rXwBkENKs0w0E3vX3ARPRrw09bkXFPT4");
            login.setServerAuthText("ZD8I2i1CAahknIMw");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(1);
            login.setLoginId("HAJNUDYMZxzWemnWMaJnUX3Y3wRTAR4UqSMWLPpVji8H1OgpJ2");
            login.setServerAuthImage("L1dtKE5BzBURUtGolWfTZNzH45r9GuhQ");
            login.setServerAuthText("c0zo86wxYHfun6uK");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
