package backend.community.global.auth.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;

import static org.apache.naming.SelectorContext.prefix;

@Component
@ConfigurationProperties(prefix = "jwt")
@Getter @Setter
public class JwtProperties {

    private String secret;
    private long expiration;
}
