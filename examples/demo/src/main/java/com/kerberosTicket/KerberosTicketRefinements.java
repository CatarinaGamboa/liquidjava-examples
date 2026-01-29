package com.kerberosTicket;

import java.net.InetAddress;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.security.auth.kerberos.KerberosPrincipal;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.security.auth.kerberos.KerberosTicket")
@StateSet({"created", "destroyed"})
public interface KerberosTicketRefinements {
    
    @StateRefinement(to="created(this)")
    public void KerberosTicket(
        byte[] asn1Encoding,
        KerberosPrincipal client,
        KerberosPrincipal server,
        byte[] sessionKey,
        int keyType,
        boolean[] flags,
        Date authTime,
        Date startTime,
        Date endTime,
        Date renewTill,
        InetAddress[] clientAddresses
    );

    @StateRefinement(from="created(this)")
    public SecretKey getSessionKey();

    @StateRefinement(from="created(this)")
    public int getSessionKeyType();

    @StateRefinement(from="created(this)")
    public byte[] getEncoded();

    @StateRefinement(from="created(this)")
    public void refresh();

    @StateRefinement(from="created(this)", to="destroyed(this)")
    public void destroy();
}
