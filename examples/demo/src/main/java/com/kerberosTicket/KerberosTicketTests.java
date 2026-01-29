package com.kerberosTicket;

import javax.security.auth.kerberos.KerberosTicket;

public class KerberosTicketTests {
    
    public void testGetSessionKeyAfterDestroyed() throws Exception {
        KerberosTicket kt = new KerberosTicket(null, null, null, null, 0, null, null, null, null, null, null);
        kt.refresh();
        kt.destroy();
        kt.getSessionKey();
    }

    public void testDestroyTwice() throws Exception {
        KerberosTicket kt = new KerberosTicket(null, null, null, null, 0, null, null, null, null, null, null);
        kt.getEncoded();
        kt.destroy();
        kt.destroy();
    }

    public void testOk() throws Exception {
        KerberosTicket kt = new KerberosTicket(null, null, null, null, 0, null, null, null, null, null, null);
        kt.refresh();
        kt.getSessionKey();
        kt.destroy();
    }
}
