package de.vinado.boot.dkim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * Condition which ensures an existing <em>dkim.private-key</em> has a non-empty value.
 *
 * @author Vincent Nadoll
 */
@Slf4j
class PrivateKeyNotEmpty implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        log.trace("Validating DKIM private key configuration property");
        String privateKey = context.getEnvironment().getProperty("dkim.private-key");
        if (StringUtils.isEmpty(privateKey)) {
            log.warn("Private key property must not be null");
            return false;
        }

        return true;
    }
}
