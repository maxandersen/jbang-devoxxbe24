//usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
//DEPS com.amazonaws:aws-lambda-java-core:1.2.3
//DEPS com.amazonaws:aws-lambda-java-events:3.11.1
//DEPS com.amazonaws:aws-lambda-java-runtime-interface-client:2.6.0
//DEPS com.amazonaws:aws-lambda-java-serialization:1.1.5

//SOURCES Person.java
//MAIN com.amazonaws.services.lambda.runtime.api.client.AWSLambda

//JAVA_OPTS -XX:MaxHeapSize=445645k 
//JAVA_OPTS -XX:+UseSerialGC -Xshare:on 
//JAVA_OPTS -XX:+TieredCompilation -XX:TieredStopAtLevel=1
//JAVA_OPTS --add-opens=java.base/java.io=ALL-UNNAMED 
//JAVA_OPTS -Dorg.crac.Core.Compat=com.amazonaws.services.lambda.crac 
//JAVA_OPTS -Djava.net.preferIPv4Stack=true 

/** Just in package example to work with default AWS Lambda package
 *  Could just be in root but then need to change the class name.
 */
package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import java.util.Map;

public class Hello implements RequestHandler<Person, String> {

    @Override
    public String handleRequest(Person event, Context context) {
        context.getLogger().log("Request received: " + event);

        return "ok";
    }
}
