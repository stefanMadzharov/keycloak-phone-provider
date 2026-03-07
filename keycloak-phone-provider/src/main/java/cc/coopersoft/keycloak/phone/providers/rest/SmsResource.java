package cc.coopersoft.keycloak.phone.providers.rest;

import cc.coopersoft.keycloak.phone.providers.constants.TokenCodeType;
import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class SmsResource {

    private static final Logger logger = Logger.getLogger(SmsResource.class);
    private final KeycloakSession session;

    public SmsResource(KeycloakSession session) {
        this.session = session;
        logger.info("SmsResource created for realm: " + session.getContext().getRealm().getName());
    }

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test() {
        logger.info("TEST ENDPOINT CALLED!");
        return Response.ok("{\"status\":\"ok\"}").build();
    }

    @Path("verification-code")
    public VerificationCodeResource getVerificationCodeResource() {
        return new VerificationCodeResource(session);
    }

    @Path("authentication-code")
    public TokenCodeResource getAuthenticationCodeResource() {
        return new TokenCodeResource(session, TokenCodeType.AUTH);
    }

    @Path("registration-code")
    public TokenCodeResource getRegistrationCodeResource() {
        return new TokenCodeResource(session, TokenCodeType.REGISTRATION);
    }

    @Path("reset-code")
    public TokenCodeResource getResetCodeResource() {
        return new TokenCodeResource(session, TokenCodeType.RESET);
    }

    @Path("otp-code")
    public TokenCodeResource getOTPCodeResource() {
        return new TokenCodeResource(session, TokenCodeType.OTP);
    }

}
