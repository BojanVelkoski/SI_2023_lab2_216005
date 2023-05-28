import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void multipleConditionsTest(){
        //if (user == null || user.getPassword() == null || user.getEmail() == null)
        //T || X || X
        assertThrows(RuntimeException.class, ()->SILab2.function(new User(null, null, null), new ArrayList<>()));

        //F || T || X
        assertThrows(RuntimeException.class, ()->SILab2.function(new User("Bojan", null, null), new ArrayList<>()));

        //F || F || T
        assertThrows(RuntimeException.class, ()->SILab2.function(new User("Bojan", "proekt123!", null), new ArrayList<>()));

        //F || F || F
        assertTrue(SILab2.function(new User("Bojan", "proekt123!", "bvelkoski3@.com"), new ArrayList<>()));
    }

    @Test
    void everyBranchTest(){
        //1* user=null, allUsers=anything
        assertThrows(RuntimeException.class, ()-> SILab2.function(null, null));

        //2* user={null, pass, abc@.com}, allUsers={User[0]={abc, password, abc@.com}, User[1]={Joe, password, Joe@.com}
        ArrayList<User> users=new ArrayList<>();
        users.add(new User("abc", "password", "abc@.com"));
        users.add(new User("Joe", "password", "Joe@.com"));
        assertFalse(SILab2.function(new User(null, "pass", "abc@.com"), users));

        //3* user={Bojan, Proekt 123, Bvelkoski3@.com}, allUsers=emptyList
        assertFalse(SILab2.function(new User("Bojan", "Proekt 123", "Bvelkoski3@.com"), users));

        //4* user={Bojan, Proekt123, Bvelkoski3@.com}, allUsers=emptyList
        assertFalse(SILab2.function(new User("Bojan", "Proekt123", "Bvelkoski3@.com"), users));

        //5* user={Bojan, Proekt123!, Bvelkoski3@.com}, allUsers=emptyList
        assertTrue(SILab2.function(new User("Bojan", "Proekt123!", "Bvelkoski3@.com"), users));
    }

}