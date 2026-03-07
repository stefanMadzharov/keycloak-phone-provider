#!/bin/bash

# Compile keycloak-phone-provider for KC 26.4 with Java 17

export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-arm64
export PATH=$JAVA_HOME/bin:$PATH

cd /workspaces/keycloak-phone-provider

echo "Building keycloak-phone-provider..."
mvn package -DskipTests -pl keycloak-phone-provider,keycloak-phone-provider.resources,keycloak-sms-provider-dummy

echo ""
echo "Build complete. JARs:"
ls -lh target/providers/keycloak-phone-provider.jar target/providers/keycloak-phone-provider.resources.jar target/providers/keycloak-sms-provider-dummy.jar
