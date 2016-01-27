package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.Address;
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
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("QUv4nixHPaWyHgFju9w40kSeo8HUDVIqhYKUtmC1BrxEozooES");
            addresstype.setAddressTypeDesc("vwh1xWU4QWdxJKkQnTjQvVWiCJqsZLsrIVq6U7Y4NKru6dUNLt");
            addresstype.setAddressTypeIcon("IGiANXEspO9rx4oTJN0pYneAl1fPLyuA0JEOFqu8bmLW0uqVzx");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("FTNVMXPRlEBvNDpDDCRDofuE32pBjZmd");
            city.setCityDescription("tNoqMn1Nwa3i1rLZTR6AVaPYrdDTRvaHyH2NRg5gSzIogZ42cP");
            city.setCityFlag("M72Rb2tTwsJUK7YbibHHEBchA091bExEQyWlIzSiawWTU2Otqh");
            city.setCityLatitude(2);
            city.setCityLongitude(10);
            city.setCityName("gHWaKQVElSOXoELvxq7QuIhXWDiQjh93IX1A02pRtIypFdzwER");
            Country country = new Country();
            country.setCapital("GU03a0edMKb8acdALUWeYJvQygms70UJ");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(4);
            country.setCountryCode1("q7G");
            country.setCountryCode2("adP");
            country.setCountryFlag("4FQNFme27tMo6OgIk2uDnrSQKzP2kIDs6WrIrp0ao2b5EQZOlT");
            country.setCountryName("JUU5Cin5qy8jYN5GowtAiUfy4aY2Tgu4I5w40gyYzixspLgk4I");
            country.setCurrencyCode("bhh");
            country.setCurrencyName("EoiJtD0NLZZLvmQCwT4Zz6JGKoLUFRhtaA4CmqVOT7TGwzuyex");
            country.setCurrencySymbol("KPGDknHn3Suj2AkxBkOSnfF7yCXdsU0J");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("oGACthE4kZaaeQiagPy0CE89fVltlsodcOMwy0hBnkB4UhUDJV");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(10);
            state.setStateCode(1);
            state.setStateCodeChar2("Bs0yUfsdVnwpQGrWyzvCIIp7MZ1KokNJ");
            state.setStateCodeChar3("IXirXvgsKvhnEG8UzZjDD7GbzNBogY28");
            state.setStateDescription("mP1E9KO69PQeUrPRuSSugOBJYaeFDV8uwOLJWXAfrbB9NjxgsC");
            state.setStateFlag("ArXHFTg9zIWiX8zPxqSKZtboB0aA5zFFZmo7e8dGeQpnp7yklk");
            state.setStateName("V7dkuGvBJfRacOguBTmj7tB6VhyQDKd5ovoaqbFHRmIh99SLYf");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("FhRGhtz1OOPVDFs4IEixpscM0rPjpGQo");
            city.setCityDescription("c8wgzK4Omx25Gsy7wFWTodMEfdkUblFW3VjJDWzJIPGvqpwpne");
            city.setCityFlag("55yavV2fJ6tIeVsfUnGM4uYg59eXX2qYoVTI4whnkFuuq4ex9g");
            city.setCityLatitude(7);
            city.setCityLongitude(9);
            city.setCityName("f8fw7wgLkW6NB0lk6gqmBVHmfn788ppZvb61V4x5cwquqrOu5S");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("XYoUdEUVkDfDvn8eFVi0rd0oEkHt63GKiP05k975ICsVC7MLnX");
            address.setAddress2("dflMiDTE1e3Dqo70HNLP9FeOC4IDaszR39HtIcb0uPlCLmJWwM");
            address.setAddress3("vTHCHGFexb77MIppkChuuK1trMgnvhENDBCaXPGxKlR2APjUXW");
            address.setAddressLabel("NPWz9lajvbD");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("46be7wa3tyUWA5cO3VSnVUKUYcfMjBavLIcjB0v3GzGYTQjDTx");
            address.setLongitude("qqNQoWTRlnYZBQVI7I9840ElriCNcFVC9PUkcDNSk6DlEYx2fw");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("pxiBEP");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("8bBXESpk9gVSIaolnY2rtqjfBZyWbZcGEBn7fT7f3vQwHrwwbB");
            address.setAddress2("yiNpzsI9LEVprDTW27Uc40ZEr3ZzC1NpGQOxtbxIQZE12lWmiq");
            address.setAddress3("pzV3RBtVanF2dUk3fTrp9QLAusz6fXuLSsla6TpYY8IFsU4vlt");
            address.setAddressLabel("NfggiEHUInN");
            address.setLatitude("XTA9586teZxLhVxGDp1Gp1ajoKz7b8YxsPDGlUsDdd8HiyqIUT");
            address.setLongitude("EiU5l0OC7yZIQWDkmn46FZR1jtIdwGPyPz5P0W8w2ekSUxy7VI");
            address.setVersionId(1);
            address.setZipcode("NddIjk");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
